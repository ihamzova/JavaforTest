package adressbook.tests;

import adressbook.model.UserData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class UserCreation extends Testbase {


  @Test
  public void testCreateNewUser() throws Exception {
    app.goTo().homePage();
    List<UserData> before = app.user().userList();
    UserData user = new UserData().withName("Василий").withSurname("Волков");
    app.user().сreateUser(user);
    app.goTo().homePage();
    List<UserData> after = app.user().userList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}

