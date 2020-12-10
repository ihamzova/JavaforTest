package test.folderadressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {

  @Test
  public void testDeleteGroup() throws Exception {
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
