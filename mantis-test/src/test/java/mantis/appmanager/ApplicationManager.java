package mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  private final Properties properties;
  public WebDriver wd;
  public String browser;
  private RegistrationHelper registrationHelper;
  private FtpHelper ftp;
  private MailHelper mailHelper;
  private DbHelper dbHelper;
  private SessionHelper session;
  private NavigationHelper goTo;
  private UserHelper user;
  private SessionHelper sessionHelper;
  private SoapHelper soapHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();

  }


  public void init() throws IOException {

    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    dbHelper = new DbHelper();
  }

  public void stop() {
    if (wd != null) {
      wd.quit();
    }
  }

  public String getProperty(String key) {
    return properties.getProperty(key);
  }


  public WebDriver getDriver() {
    if (wd == null) {
      if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.IE)) {
        wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
      wd.get(properties.getProperty("web.baseUrl"));
    }
    return wd;
  }

  public RegistrationHelper registration() {
    if (registrationHelper == null) {
      registrationHelper = new RegistrationHelper(this);
    }
    return registrationHelper;
  }
  public HttpSession newSession() {
    return new HttpSession(this);
  }
  public MailHelper mail() {
    if (mailHelper == null) {
      mailHelper = new MailHelper(this);
    }
    return mailHelper;
  }
  public FtpHelper ftp() {
    if (ftp == null) {
      ftp = new FtpHelper(this);
    }
    return ftp;
  }
  public DbHelper db() {
    return dbHelper;
  }
  public SessionHelper session() {
    if (session == null) {
      session = new SessionHelper(this);
    }
    return session;
  }
  public NavigationHelper goTo() {
    if (goTo == null) {
      goTo = new NavigationHelper(this);
    }
    return goTo;
  }
  public UserHelper user() {
    if (user == null) {
      user = new UserHelper(this);
    }
    return user;
  }
  public SoapHelper soap() {
    if (soapHelper == null) {
      soapHelper = new SoapHelper(this);
    }
    return soapHelper;
  }
}
