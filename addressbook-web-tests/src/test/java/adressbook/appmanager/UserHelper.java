package adressbook.appmanager;

import adressbook.model.UserData;
import adressbook.model.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


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
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }
  private void selectUserbyId(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click(); }
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
    closeAlertPage();
  }
  public void delete(UserData user) {
    selectUserbyId(user.getId());
    deleteSelectedUser();
    closeAlertPage();
  }

  public boolean isThereAUser() {
    return isElementPresent(By.name("selected[]"));
  }
  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
  //click(By.xpath("//input[@value='Delete']"));

  public Users all() {
    Users userList = new Users();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement el : elements) {
      String firstname = el.findElement(By.xpath(".//td[3]")).getText();
      String surname = el.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(el.findElement(By.tagName("input")).getAttribute("id"));
      UserData userData = new UserData().withtId(id).withName(firstname).withSurname(surname);
      userList.add(userData);
    }
    return userList;

  }

  public void closeAlertPage() {
    wd.switchTo().alert().accept();
  }







}
