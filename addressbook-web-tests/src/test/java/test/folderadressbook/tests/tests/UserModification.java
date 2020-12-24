package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

import java.util.List;

public class UserModification extends Testbase {

  @Test
  public void testUserModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData("Nih", "Fedorh", null, null, "8911287483", null));
    }
    List<UserData> before=app.userHelper.getUserList();
    app.getUserHelper().selectUser(0);
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("Ari1", "Bely1", null, null, null, null));
    app.getUserHelper().submitModification();
    app.getNavigationHelper().goToHomePage();
    List<UserData> after =app.userHelper.getUserList();
    Assert.assertEquals(after.size(), before.size());


  }

}