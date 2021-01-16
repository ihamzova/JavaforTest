package adressbook.appmanager;

import adressbook.model.UserData;
import adressbook.model.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserHelper extends Helperbase {

  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void addNewUser() {
    click(By.linkText("add new"));
  }

  public void createUser(UserData userData) {
    addNewUser();
    fillUserForm(new UserData().withName("Анна").withSurname("Сидорова"));
    submitNewUser();

  }

  public void сreateUser(UserData user) {
    addNewUser();
    fillUserForm(user);
    submitNewUser();
    userCache = null;
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  private void selectUserbyId(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void submitNewUser() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }


  public void fillUserForm(UserData userData) {
    type("firstname", userData.getName());
    type("lastname", userData.getSurname());
  }

  public UserData modifyUser(UserData user, int index) {
    selectUser(index);
    initUserModification();
    fillUserForm(user);
    submitModification();
    return user;
  }

  public void initUserModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitModification() {
    click(By.name("update"));

  }

  public void modify(UserData user) {
    selectUserbyId(user.getId());
    initUserModificationbyId(user.getId());
    fillUserForm(user);
    submitModification();
  }

  private void initUserModificationbyId(int id) {
    wd.findElement(By.xpath("//a[@href='edit.php?id=" + id + "']")).click();
  }

  public void deleteSelectedUser() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));
  }

  public void deleteUser(int index) {
    selectUser(index);
    deleteSelectedUser();
    userCache = null;
    closeAlertPage();
  }

  public void delete(UserData user) {
    selectUserbyId(user.getId());
    deleteSelectedUser();
    userCache = null;
    closeAlertPage();
  }

  public void closeAlertPage() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Users userCache = null;

  public Users all() {
    if (userCache != null) {
      return new Users(userCache);
    }
    userCache = new Users();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement el : elements) {
      String firstname = el.findElement(By.xpath(".//td[3]")).getText();
      String surname = el.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(el.findElement(By.tagName("input")).getAttribute("id"));
      UserData userData = new UserData().withtId(id).withName(firstname).withSurname(surname);
      userCache.add(userData);
    }
    return userCache;

  }


  public Set<UserData> allUsersInfo() {
    Set<UserData> users = new HashSet<UserData>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement el : elements) {
      String firstname = el.findElement(By.xpath(".//td[3]")).getText();
      String surname = el.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(el.findElement(By.tagName("input")).getAttribute("id"));
      String allPhones = elements.get(5).getText();
      String allemails = elements.get(4).getText();
      String address = elements.get(3).getText();
      UserData userData = new UserData().withtId(id).withName(firstname).
              withSurname(surname).withAllphones(allPhones).
              withAllemails(allemails).withaddress(address);
      users.add(userData);
    }
    return users;

  }


  public UserData getInfoFromEditForm(UserData userData) {
    initUserModificationbyId(userData.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homenumber = wd.findElement(By.name("home")).getAttribute("value");
    String mobilenumber = wd.findElement(By.name("mobile")).getAttribute("value");
    String worknumber = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new UserData().withtId(userData.getId()).withName(userData.getName()).withSurname(userData.getSurname()).withHomenumber(userData.getHomephones())
            .withMobilenumber(userData.getMobilephones()).withWorknumber(userData.getWorkphones());

  }
}
