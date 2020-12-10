package test.folderadressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroup extends Testbase {


  @Test
  public void testDeleteGroup() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteGroup();
    returnToGroupPage();
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }


}
