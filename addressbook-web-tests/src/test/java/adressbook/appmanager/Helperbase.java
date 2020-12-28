package adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Helperbase {
  protected WebDriver wd;

  public Helperbase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(String locator, String text) {
    click(By.name(String.valueOf(locator)));
    if (text != null) {
      String existingText = wd.findElement(By.name(String.valueOf(locator))).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(By.name(String.valueOf(locator))).clear();
        wd.findElement(By.name(String.valueOf(locator))).sendKeys(text);
      }

    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
