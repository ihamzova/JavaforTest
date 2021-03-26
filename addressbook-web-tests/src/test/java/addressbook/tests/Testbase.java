package addressbook.tests;

import addressbook.appmanager.ApplicationManager;
import addressbook.model.GroupData;
import addressbook.model.Groups;
import addressbook.model.UserData;
import addressbook.model.Users;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;

import static org.hamcrest.MatcherAssert.*;

public class Testbase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public void verifyGroupListinUi() {
    if (Boolean.getBoolean("verifyUI")) {
      Groups dbGroups = app.db().groups();
      Groups uiGroups = app.group().all();
      assertThat(uiGroups, equalTo(dbGroups.stream().map((g) -> new GroupData().withName(getClass().getName()))
              .collect(Collectors.toSet())));
    }


  }

  public void verifyUserListinUi() {
    if (Boolean.getBoolean("verifyUI")) {
      Users dbUsers = app.db().users();
      Users uiUsers = app.user().all();
      assertThat(uiUsers, equalTo(dbUsers.stream().map((g) -> new GroupData().withName(getClass().getName()))
              .collect(Collectors.toSet())));
    }


  }
}
