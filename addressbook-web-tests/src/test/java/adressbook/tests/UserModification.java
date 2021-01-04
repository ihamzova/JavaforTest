package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import adressbook.model.UserData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserModification extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (app.user().all().size() == 0) {
      app.user().createUser(new UserData().withName("Петр").withSurname("Кузнецов"));
    }

  }

  @Test
  public void testUserModification() {
    Set<UserData> before = app.user().all();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().
            withtId(modifiedUser.getId()).withName("Кристина").withSurname("Левонова");
    app.user().modify(user);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedUser);
    before.add(user);
    Assert.assertEquals(before, after);


  }


}