package test.folderadressbook.tests;

import org.testng.annotations.Test;
import test.folderadressbook.model.GroupData;

public class NewGroupCreation {

  @Test
  public void testCreateNewGroup() throws Exception {
<<<<<<< HEAD
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    submitGroupCreation();
    returnToGroupPage();
=======
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
>>>>>>> parent of eb8e814... Revert "NavigationHelper"
  }

}
