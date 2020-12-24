package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

import java.util.List;

public class GroupModification extends Testbase {
  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.groupHelper.getGroupList();
    if (!app.getGroupHelper().isGroupPresent()) {
      app.getGroupHelper().createGroup(new GroupData("Testgroup35", null, null));
    }
    app.getGroupHelper().selectGroup(0);
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("Grouptest", "new group", "secondname"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(),before.size());
  }
}
