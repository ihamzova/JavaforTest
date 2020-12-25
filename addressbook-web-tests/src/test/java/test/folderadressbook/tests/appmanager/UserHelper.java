package test.folderadressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import test.folderadressbook.tests.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserHelper extends Helperbase {

  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void submitNewUser() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillUserForm(UserData userData) {
    type("firstname", userData.getName());
    type("lastname", userData.getSurname());
    type("nickname", userData.getNickname());
    type("company", userData.getCompany());
    type("mobile", userData.getPhone());
    type("email", userData.getEmail());

  }

  public void addNewUser() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedUser() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectUser(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }


  public void initUserModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitModification() {
    click(By.name("update"));

  }

  public void createUser(UserData userData) {
    addNewUser();
    fillUserForm(new UserData("Bar4", "Ivan12", "mo1", "Tes11", "89l818120", null));
    submitNewUser();

  }

  public boolean isUserPresent() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getUserCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<UserData> getUserList() {
    List<UserData> userList = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement el : elements) {
      String name = el.getText();
      UserData userData= new UserData(name,null, null, null, null,null);
      userList.add(userData);
    }
    return userList;

}}
