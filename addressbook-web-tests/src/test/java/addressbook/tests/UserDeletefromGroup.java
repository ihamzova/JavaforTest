package addressbook.tests;

import addressbook.appmodel.GroupData;
import addressbook.appmodel.Groups;
import addressbook.appmodel.UserData;
import addressbook.appmodel.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserDeletefromGroup extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().users().size() == 0) {
      app.goTo().homePage();
      app.user().createUser(new UserData()
              .withName("Anna").withSurname("Smirnova"));

    }
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test5"));
    }
  }

  @Test
  public void testContactRemoveFromGroup() {
    UserData user = selectUser();
    GroupData fromGroup = selectGroup(user);
    Groups before = user.getGroups();
    app.goTo().homePage();
    app.user().groupPage(fromGroup.getId());
    app.user().removeFromGroup(user, fromGroup);
    UserData usersAfter = selectUserById(user);
    Groups after = usersAfter.getGroups();
    assertThat(after, equalTo(before.without(fromGroup)));
  }

  private UserData selectUserById(UserData user) {
    Users usersById = app.db().users();
    return usersById.iterator().next().withtId(user.getId());

  }

  private UserData selectUser() {
    Users allUsers = app.db().users();
    for (UserData user : allUsers) {
      if (user.getGroups().size() > 0) {
        return user;
      }
    }
    UserData addUser = app.db().users().iterator().next();
    app.user().addToGroup(addUser, app.db().groups().iterator().next());
    return addUser;
  }

  private GroupData selectGroup(UserData removeUser) {
    UserData user = selectUserById(removeUser);
    Groups removedUser = user.getGroups();
    return removedUser.iterator().next();
  }
}


