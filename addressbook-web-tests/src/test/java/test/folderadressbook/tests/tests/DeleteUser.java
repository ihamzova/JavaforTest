package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.appmanager.ApplicationManager;

public class DeleteUser extends Testbase {

  //private final ApplicationManager app = new ApplicationManager();

  @Test
  public void testDeleteUser() throws Exception {
    app.navigationHelper.returnHomePage();
    app.userHelper.selectUser("25");
    app.userHelper.deleteSelectedUser();
    app.navigationHelper.closeAlertPage();
    app.navigationHelper.returnHomePage();

  }

  public ApplicationManager getApplicationManager() {
    return app;
  }
}





