package test.folderadressbook.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.folderadressbook.appmanager.ApplicationManager;

import java.util.concurrent.TimeUnit;

public class Testbase {

protected final ApplicationManager app =new ApplicationManager();

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    init();
  }

  public void init() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost:8080/addressbook/group.php");
    login("admin", "secret");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    stop();
  }

  public void stop() {
    wd.quit();
  }

}
