package test.folderadressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.folderadressbook.tests.model.GroupData;

public class GroupHelper extends  Helperbase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type("group_name", groupData.getName());
    type("group_header", groupData.getHeader());
    type("group_footer", groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteGroup() {
    click(By.name("delete"));
  }

  public void selectGroup() {
    click(By.xpath("(//input[@name='selected[]'])[2]"));
  }
}
