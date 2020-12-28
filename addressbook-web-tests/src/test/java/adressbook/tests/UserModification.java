package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import adressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserModification extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.user().userList().size() == 0) {
      app.user().createUser(new UserData().withName("Петр").withSurname("Кузнецов"));
    }

  }

  @Test
  public void testUserModification() {
    List<UserData> before = app.user().userList();
    int index = 0;
    UserData user = new UserData().withtId(before.get(index).getId()).withName("Максим").withSurname("Харченко");
    app.user().modifyUser(user, index);
    app.goTo().homePage();
    List<UserData> after = app.user().userList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(user);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}