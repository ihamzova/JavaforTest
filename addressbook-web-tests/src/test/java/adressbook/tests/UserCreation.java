package adressbook.tests;

import adressbook.model.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class UserCreation extends Testbase {


  @Test(enabled = false)
  public void testCreateNewUser() throws Exception {
    app.getNavigationHelper().goToHomePage();
    List<UserData> before = app.userHelper.getUserList();
    app.getUserHelper().addNewUser();
    UserData user = new UserData("Василиса1", "Петрова1", null, null, null, null);
    app.getUserHelper().fillUserForm(user);
    app.getUserHelper().submitNewUser();
    app.getNavigationHelper().goToHomePage();
    List<UserData> after = app.userHelper.getUserList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}

