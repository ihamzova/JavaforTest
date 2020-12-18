package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

public class UserCreation extends Testbase {



  @Test
  public void testCreateNewUser() throws Exception {
    app.getNavigationHelper().returnHomePage();
    app.getUserHelper().createNewUser();
    app.getUserHelper().fillUserForm(new UserData("Barijna1", "Ivanovjich1", "mojnkey1", "TestSchjopol1", "898112097633k", "ihva@yandex.ru"));
    app.getUserHelper().submitNewUser();
    app.getNavigationHelper().returnHomePage();
  }


}
