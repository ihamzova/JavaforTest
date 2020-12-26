package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

import java.util.HashSet;
import java.util.List;

public class UserModification extends Testbase {

  @Test
  public void testUserModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData("Nih", "Fedorh", null, null, null, null));
    }
    List<UserData> before = app.userHelper.getUserList();
    app.getUserHelper().selectUser(0);
    app.getUserHelper().initUserModification();
    UserData user = new UserData(before.get(before.size() - 1).getId(), "Максим", "Круглов", null, null, null, null);
    app.getUserHelper().fillUserForm(user);
    app.getUserHelper().submitModification();
    app.getNavigationHelper().goToHomePage();
    List<UserData> after = app.userHelper.getUserList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(0);
    before.add(user);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


  }

}