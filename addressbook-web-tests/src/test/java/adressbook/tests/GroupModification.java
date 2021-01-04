package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModification extends Testbase {

  @BeforeMethod

  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("Testgroup57"));
    }

  }

  @Test
  public void testGroupModification() {

    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("Testgroup55").withHeader("группа1");
    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);

  }


}

