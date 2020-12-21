package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;

public class DeleteUser extends Testbase {

  //private final ApplicationManager app = new ApplicationManager();

  @Test
  public void testDeleteUser() throws Exception {
    app.navigationHelper.goToHomePage();
    app.userHelper.selectUser();
    app.userHelper.deleteSelectedUser();
    app.navigationHelper.closeAlertPage();
    app.navigationHelper.goToHomePage();

  }

}





