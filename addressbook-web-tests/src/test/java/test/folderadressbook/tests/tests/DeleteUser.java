package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

public class DeleteUser extends Testbase {

  @Test
  public void testDeleteUser() throws Exception {
    app.navigationHelper.goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData("Nika", "Fedorovich", null, null, "8911287483", null));
    }
    app.userHelper.selectUser();
    app.userHelper.deleteSelectedUser();
    app.navigationHelper.closeAlertPage();
    app.navigationHelper.goToHomePage();

  }

}





