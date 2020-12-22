package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.UserData;

public class UserModification extends Testbase {

  @Test
  public void testUserModification() {
    app.getNavigationHelper().goToHomePage();
    if (!app.getUserHelper().isUserPresent()) {
      app.getUserHelper().createUser(new UserData("Nih", "Fedorh", null, null, "8911287483", null));
    }
    app.getUserHelper().selectUser();
    app.getUserHelper().initUserModification();
    app.getUserHelper().fillUserForm(new UserData("Arina", "Belya", "fox", "Too", "891128758", "drighf@ya.ru"));
    app.getUserHelper().submitModification();
    app.getNavigationHelper().goToHomePage();


  }

}