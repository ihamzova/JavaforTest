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

  public void addNewUser() {
    click(By.linkText("add new"));
  }

  public void deleteSelectedUser() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectUser() {
    click(By.name("selected[]"));
  }
  //By.xpath("//td[1]/input[@type='checkbox']"));

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
}
