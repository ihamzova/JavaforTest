package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

import java.util.List;

public class DeleteUser extends Testbase {

  @Test
  public void testDeleteUser() throws Exception {
    app.navigationHelper.goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData("Nika", "Fedorovich", null, null, "8911287483", null));
    }
    List<UserData> before = app.userHelper.getUserList();
    app.userHelper.selectUser(before.size() - 1);
    app.userHelper.deleteSelectedUser();
    app.navigationHelper.closeAlertPage();
    app.navigationHelper.goToHomePage();
    List<UserData> after = app.userHelper.getUserList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);


  }

}





