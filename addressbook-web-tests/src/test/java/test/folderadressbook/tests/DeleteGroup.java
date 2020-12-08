package test.folderadressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {

  @Test
  public void testDeleteGroup() throws Exception {
    app.goToGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage();
  }

}
