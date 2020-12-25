package test.folderadressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

import java.util.HashSet;
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
    GroupData group= new GroupData(before.get(before.size()-1).getId(),"Grouptest22", "new group2", "secondname2");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(),before.size());
    before.remove(0);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }
}
