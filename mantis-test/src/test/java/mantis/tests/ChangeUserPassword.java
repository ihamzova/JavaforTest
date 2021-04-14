package mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import mantis.model.MailMessage;
import mantis.model.UserData;
import mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ChangeUserPassword extends Testbase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testChangingUserPassword() throws IOException, MessagingException {
    Users before = app.db().users();
    before.removeIf(elem -> elem.getUsername().equals("administrator"));
    if (before.size() == 0) {
      return;
    }
    UserData modifyUser = before.iterator().next();

    long time = System.currentTimeMillis();

    String password = "password";
    String email = modifyUser.getEmail();
    String user = modifyUser.getUsername();
    app.session().loginUI("administrator", "root");
    app.goTo().manageUserPage();
    app.user().selectUser(modifyUser.getId());
    app.user().resetPassword();
    app.session().logout();

    List<MailMessage> mailMessages = app.mail().waitForMail(2, 60000);
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }


  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
