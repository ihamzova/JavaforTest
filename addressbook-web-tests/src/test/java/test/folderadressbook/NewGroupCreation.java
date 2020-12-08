package test.folderadressbook;

import org.testng.annotations.Test;

public class NewGroupCreation extends Testbase{

  @Test
  public void testCreateNewGroup() throws Exception {
    goToGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Testgroup3", "Test Group for lesson 2", "TestGroup"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
