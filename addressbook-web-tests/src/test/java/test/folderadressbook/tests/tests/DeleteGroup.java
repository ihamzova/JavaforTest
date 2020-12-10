package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {
    gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }

  public void gotoGroupPage() {
    app.getNavigationHelper().goToGroupPage();
  }


}
