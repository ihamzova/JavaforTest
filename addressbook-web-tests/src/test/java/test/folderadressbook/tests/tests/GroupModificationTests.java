package test.folderadressbook.tests.tests;


import org.testng.annotations.Test;
import test.folderadressbook.tests.model.GroupData;

public class GroupModificationTests extends Testbase{



  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group1","Group1/1","testgroup1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

}
