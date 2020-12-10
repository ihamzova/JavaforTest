package test.folderadressbook;

import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {

  @Test
  public void testDeleteGroup() throws Exception {
<<<<<<< HEAD:addressbook-web-tests/src/test/java/test/folderadressbook/DeleteGroup.java
    goToGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
=======
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
>>>>>>> parent of eb8e814... Revert "NavigationHelper":addressbook-web-tests/src/test/java/test/folderadressbook/tests/DeleteGroup.java
  }

}
