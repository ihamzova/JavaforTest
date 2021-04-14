package addressbook.tests;

import addressbook.appmodel.GroupData;
import addressbook.appmodel.Groups;
import addressbook.appmodel.UserData;
import addressbook.appmodel.Users;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UserAddtoGroup extends Testbase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test4"));

    }

    if (app.db().users().size() == 0) {
      app.goTo().homePage();
      app.user().createUser(new UserData()
              .withName("Anna").withSurname("Smirnova"));

    }

  }

  @Test
  public void testUserAddtoGroup() {
    UserData addUser = selectUser();
    GroupData toGroup = selectGroup(addUser);
    Groups before = addUser.getGroups();
    app.goTo().homePage();
    app.user().addToGroup(addUser, toGroup);
    app.goTo().homePage();
    UserData addUserAfter = selectUserById(addUser);
    Groups after = addUserAfter.getGroups();
    assertThat(after, equalTo(before.withadded(toGroup)));


  }

  private UserData selectUserById(UserData user) {
    Users usersById = app.db().users();
    return usersById.iterator().next().withtId(user.getId());

  }

  private GroupData selectGroup(UserData user) {
    Groups allGroups = app.db().groups();
    Groups usersInGroups = user.getGroups();
    Collection<GroupData> userGroups = new HashSet<>(usersInGroups);
    Collection<GroupData> available = new HashSet<>(allGroups);
    available.removeAll(userGroups);
    return available.iterator().next();
  }

  private UserData selectUser() {
    Users allUsers = app.db().users();
    Groups allGroups = app.db().groups();
    for (UserData user : allUsers) {
      if (user.getGroups().size() < allGroups.size()) {
        return user;
      }
    }
    app.goTo().groupPage();
    app.group().create(new GroupData().withName("newTestGroup").withHeader("newHeader"));
    return allUsers.iterator().next();
  }

}
