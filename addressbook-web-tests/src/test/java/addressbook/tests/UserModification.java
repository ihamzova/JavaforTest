package addressbook.tests;

import addressbook.appmodel.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import addressbook.appmodel.UserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserModification extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    if (app.db().users().size() == 0) {
      app.goTo().homePage();
      app.user().createUser(new UserData().withName("Петр").withSurname("Кузнецов"));
    }

  }

  @Test
  public void testUserModification() {
    Users before = app.db().users();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().withtId(modifiedUser.getId()).withName("Крис19").withSurname("Кирова28");
    app.user().modify(user);
    Users after = app.db().users();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedUser).withadded(user)));
    verifyUserListinUi();

  }


}