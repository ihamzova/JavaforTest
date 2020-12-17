package test.folderadressbook.tests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends Helperbase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void goToGroupPage() {
    click(By.linkText("groups"));
  }

  public void closeAlertPage() {
    wd.switchTo().alert().accept();
  }

  public void returnHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }
}
