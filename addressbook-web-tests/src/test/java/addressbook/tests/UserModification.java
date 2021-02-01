package addressbook.tests;

import addressbook.model.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import addressbook.model.UserData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Users before = app.user().all();
    UserData modifiedUser = before.iterator().next();
    UserData user = new UserData().
            withtId(modifiedUser.getId()).withName("Крис19").withSurname("Кирова28");
    app.user().modify(user);
    app.goTo().homePage();
    Users after = app.user().all();
    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before.without(modifiedUser).withadded(user)));

  }


}