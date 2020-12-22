package test.folderadressbook.tests.tests;

import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {

    app.navigationHelper.goToGroupPage();
    if (!app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Testgroup32", null, null));

    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
  }


}
