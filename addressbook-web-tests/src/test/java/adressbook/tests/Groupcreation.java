package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class Groupcreation extends Testbase {

  @Test
  public void testCreateNewGroup() throws Exception {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
