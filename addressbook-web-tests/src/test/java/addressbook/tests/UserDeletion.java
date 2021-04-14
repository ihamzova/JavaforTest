package addressbook.tests;

import addressbook.appmodel.UserData;
import addressbook.appmodel.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class UserDeletion extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().users().size() == 0) {
      app.goTo().homePage();
      app.user().createUser(new UserData().withName("Петр").withSurname("Кузнецов"));
    }

  }

  @Test
  public void testDeleteUser() throws Exception {
    Users before = app.db().users();
    UserData deletedUser = before.iterator().next();
    app.user().delete(deletedUser);
    app.waitForMessage();
    Users after = app.db().users();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedUser)));
    verifyUserListinUi();


  }


}





