package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {

    app.navigationHelper.goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }


}
