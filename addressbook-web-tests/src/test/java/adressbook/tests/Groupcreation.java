package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class Groupcreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.groupHelper.getGroupList();
    GroupData group = new GroupData("test65", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.groupHelper.getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
