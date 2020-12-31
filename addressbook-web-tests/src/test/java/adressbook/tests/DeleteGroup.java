package adressbook.tests;

import adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class DeleteGroup extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("tesst1"));
    }

  }


  @Test
  public void testDeleteGroup() throws Exception {
    Set<GroupData> before = app.group().all();
    int index = before.size() - 1;
    delete(index);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(index);
    Assert.assertEquals(before, after);

  }

  private void delete(int index) {
    app.group().selectGroup(index);
    app.group().deleteGroup();
    app.group().returnToGroupPage();
  }
}

