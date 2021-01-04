package adressbook.tests;

import adressbook.model.UserData;
import com.sun.source.doctree.SeeTree;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class UserCreation extends Testbase {


  @Test
  public void testCreateNewUser() throws Exception {
    app.goTo().homePage();
    Set<UserData> before = app.user().all();
    UserData user = new UserData().withName("Василиса").withSurname("Волковна");
    app.user().сreateUser(user);
    app.goTo().homePage();
    Set<UserData> after = app.user().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    user.withtId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt());//сравнение групп по id->поток id
    before.add(user);
    Assert.assertEquals(before, after);

  }


}

