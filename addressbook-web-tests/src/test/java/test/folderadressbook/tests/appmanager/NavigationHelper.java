package test.folderadressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends Helperbase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    if (isElementPresent(By.tagName("h1")) &&
            wd.findElement(By.tagName("h1")).getText().equals("Groups") &&
            isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void closeAlertPage() {
    wd.switchTo().alert().accept();
  }

  public void goToHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

}
