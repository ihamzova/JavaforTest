package mantis.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }


  public void loginUI(String username, String password) {
    type(By.name("username"), username);
    click(By.xpath("//input[@value='Login']"));
    type(By.name("password"), password);
    click(By.xpath("//input[@value='Login']"));

  }

  public void logout() {
    click(By.xpath("//i[2]"));
    click(By.linkText("Logout"));

  }
}