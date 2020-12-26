package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {
    app.navigationHelper.goToGroupPage();
    if (!app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Testgroup32", null, null));

    }
    List<GroupData> before = app.groupHelper.getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteGroup();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }
}

