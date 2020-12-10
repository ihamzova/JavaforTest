package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {
    gotoGroupPage();
    app.selectGroup();
    app.deleteGroup();
    app.returnToGroupPage();
  }

  public void gotoGroupPage() {
    app.goToGroupPage();
  }


}
