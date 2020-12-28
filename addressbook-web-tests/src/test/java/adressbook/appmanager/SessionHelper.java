package adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends Helperbase {

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String password) {
    type(("user"), username);
    type(("pass"), password);
    click(By.xpath("//input[@value='Login']"));
  }
}
