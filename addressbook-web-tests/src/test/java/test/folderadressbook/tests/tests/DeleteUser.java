package test.folderadressbook.tests.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import test.folderadressbook.tests.appmanager.UserHelper;

public class DeleteUser extends UserHelper {

  @Test
  public void testDeleteUser() throws Exception {
    goHomePage();
    selectUser("27");
    deleteSelectedUser();
    closeAlertPage();
    goHomePage();

  }

  public void closeAlertPage() {
    wd.switchTo().alert().accept();
  }

  protected void goHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }
}


