package adressbook.tests;

import adressbook.model.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

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
    List<UserData> before = app.user().userList();
    int index = before.size() - 1;
    app.user().deleteUser(index);
    app.goTo().homePage();
    List<UserData> after = app.user().userList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Comparator<? super UserData> byId = (u1, u2) -> Integer.compare(u1.getId(), u2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);


  }


}





