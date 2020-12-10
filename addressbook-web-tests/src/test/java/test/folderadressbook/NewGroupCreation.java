package test.folderadressbook;

import org.testng.annotations.Test;
import test.folderadressbook.tests.GroupData;
import test.folderadressbook.tests.Testbase;

public class NewGroupCreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
