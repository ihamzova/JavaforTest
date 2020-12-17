package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

public class CreateNewUser extends Testbase {

  //private final ApplicationManager app = new ApplicationManager();

  @Test
  public void testCreateNewUser() throws Exception {
    app.getNavigationHelper().returnHomePage();
    app.getUserHelper().createNewUser();
    app.getUserHelper().fillUserForm(new UserData("Barina", "Ivanovich", "monkey", "TestSchopol", "89112097633k", "ihva@yandex.ru", "13", "September", "1990"));
    app.getUserHelper().submitNewUser();
    app.getNavigationHelper().returnHomePage();
  }


}
