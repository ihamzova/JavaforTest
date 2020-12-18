package test.folderadressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.folderadressbook.tests.model.UserData;

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

  public void createNewUser() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedUser() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectUser(String userID) {
    click(By.id(userID));
  }

  public void initUserModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitModification() {
    click(By.name("update"));

  }
}
