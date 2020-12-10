package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

public class NewGroupCreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}