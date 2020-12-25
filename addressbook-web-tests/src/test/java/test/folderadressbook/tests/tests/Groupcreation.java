package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class Groupcreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before= app.groupHelper.getGroupList();
    GroupData group=new GroupData("test22", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after= app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(),before.size()+1);
    before.add(group);
   int  max=0;
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}
