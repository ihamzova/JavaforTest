package addressbook.tests;

import addressbook.appmodel.GroupData;
import addressbook.appmodel.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModification extends Testbase {

  @BeforeMethod

  public void ensurePrecondition() {
    if (app.db().groups().size()==0)
    {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("Testgroup57"));
    }

  }

  @Test
  public void testGroupModification() {

    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().
            withId(modifiedGroup.getId()).withName("Testgroup155").withHeader("группа1").withFooter("группа2");
    app.goTo().groupPage();
    app.group().modify(group);
    Groups after = app.db().groups();
    assertEquals(after.size(), before.size());
    assertThat(after,equalTo(before.without(modifiedGroup).withadded(group)));
    verifyGroupListinUi();

  }



}

