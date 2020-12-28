package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import adressbook.model.GroupData;

import java.util.Comparator;
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
    GroupData group = new GroupData(before.get(0).getId(), "Testgroup5", "new group2", "secondname2");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(), before.size());
    before.remove(0);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }
}
