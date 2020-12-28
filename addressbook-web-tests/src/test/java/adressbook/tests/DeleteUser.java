package adressbook.tests;

import adressbook.model.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class DeleteUser extends Testbase {

  @Test(enabled = false)
  public void testDeleteUser() throws Exception {
    app.navigationHelper.goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData( "Nika", "Fedorovich", null, null, "8911287483", null));
    }
    List<UserData> before = app.userHelper.getUserList();
    app.userHelper.selectUser(before.size() - 1);
    app.userHelper.deleteSelectedUser();
    app.navigationHelper.closeAlertPage();
    app.navigationHelper.goToHomePage();
    List<UserData> after = app.userHelper.getUserList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);



  }

}





