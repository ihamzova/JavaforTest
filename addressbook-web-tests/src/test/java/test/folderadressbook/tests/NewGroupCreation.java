package test.folderadressbook.tests;

import org.testng.annotations.Test;
import test.folderadressbook.model.GroupData;

public class NewGroupCreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
