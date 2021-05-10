package addressbook.manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

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


  public void attach (String locator, File file) {
    if (file != null) {
        wd.findElement(By.name(String.valueOf(locator))).sendKeys(file.getAbsolutePath());
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
  public void waitForMessage() {
    WebElement wait = new WebDriverWait(wd, 5).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[class='msgbox']")));
  }
}
