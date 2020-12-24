package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

import java.util.List;

public class UserCreation extends Testbase {


  @Test
  public void testCreateNewUser() throws Exception {
    app.getNavigationHelper().goToHomePage();
    List<UserData> before=app.userHelper.getUserList();
    app.getUserHelper().addNewUser();
    app.getUserHelper().fillUserForm(new UserData("Bay1", "Iva11", null, null, null, null));
    app.getUserHelper().submitNewUser();
    app.getNavigationHelper().goToHomePage();
    List<UserData> after =app.userHelper.getUserList();
    Assert.assertEquals(after.size(),before.size()+1);
  }


}
