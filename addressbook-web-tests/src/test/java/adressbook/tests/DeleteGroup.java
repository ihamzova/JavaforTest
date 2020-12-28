package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class DeleteGroup extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().list().size()==0) {
      app.group().create(new GroupData().withName("tesst1"));
    }

  }


    @Test
    public void testDeleteGroup () throws Exception {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    delete(index);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

  private void delete(int index) {
    app.group().selectGroup(index);
    app.group().deleteGroup();
    app.group().returnToGroupPage();
  }
}

