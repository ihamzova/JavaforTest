package adressbook.tests;

import adressbook.model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class DeleteUser extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().homePage();
    if (!app.user().isThereAUser()) {
      app.user().createUser(new UserData().withName("Антон").withSurname("Лапенко"));
    }
  }

  @Test
  public void testDeleteUser() throws Exception {
    Set<UserData> before = app.user().all();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedUser);
    Assert.assertEquals(before, after);


  }


}





