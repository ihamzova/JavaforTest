package adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModification extends Testbase {

  @BeforeMethod

  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().list().size()==0) {
      app.group().create(new GroupData().withName("Testgroup57"));
    }

  }

  @Test
  public void testGroupModification() {

    List<GroupData> before = app.group().list();
    int index = 0;
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("Testgroup55");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());
    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}

