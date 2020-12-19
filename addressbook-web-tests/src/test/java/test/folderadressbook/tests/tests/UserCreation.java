package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

public class UserCreation extends Testbase {


  @Test
  public void testCreateNewUser() throws Exception {
    app.getNavigationHelper().goToHomePage();
    app.getUserHelper().createNewUser();
    app.getUserHelper().fillUserForm(new UserData("Barl6ijna11", "Ivanlo8vjich11", "moj6lnkey21", "TestSch8jlopol11", "89l81812097633k", "ihva@yandex.ru"));
    app.getUserHelper().submitNewUser();
    app.getNavigationHelper().goToHomePage();
  }


}
