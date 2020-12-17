package test.folderadressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.folderadressbook.tests.appmanager.UserHelper;
import test.folderadressbook.tests.model.UserData;

public class CreateNewUser extends UserHelper {

  @Test
  public void testCreateNewUser() throws Exception {
    createNewUser();
    fillUserForm(new UserData("Barina", "Ivanovich", "monkey", "TestSchopol", "89112097633k", "ihva@yandex.ru", "13", "September", "1990"));
    submitNewUser();
    goHomePage();
  }

  protected void goHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }
}
