package addressbook.tests;

import addressbook.model.GroupData;
import addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletion extends Testbase {
  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("tesst1"));
    }

  }


  @Test
  public void testDeleteGroup() throws Exception {
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    app.waitForMessage();
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);
    before.remove(deletedGroup);
    assertEquals(before, after);
    assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListinUi();
  }


}

