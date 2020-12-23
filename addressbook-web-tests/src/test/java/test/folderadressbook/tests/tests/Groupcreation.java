package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

public class Groupcreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    int before=app.getGroupHelper().getGroupCount();
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("test22", null, null));
    int after= app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after,before+1);
  }

}
