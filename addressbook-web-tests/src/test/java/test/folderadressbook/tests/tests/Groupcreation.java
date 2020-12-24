package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

import java.util.List;

public class Groupcreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before= app.groupHelper.getGroupList();
    app.getGroupHelper().createGroup(new GroupData("test22", null, null));
    List<GroupData> after= app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);
  }

}
