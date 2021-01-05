package adressbook.tests;

import adressbook.model.UserData;
import adressbook.model.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Users before = app.user().all();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    app.goTo().homePage();
    Users after = app.user().all();
    assertEquals(after.size(), before.size() - 1);
    before.remove(deletedUser);
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(deletedUser)));


  }


}





