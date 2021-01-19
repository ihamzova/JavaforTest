package adressbook.tests;

import adressbook.model.UserData;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailCheck extends Testbase {
  @Test
  public void testContactEmail() {
    app.goTo().homePage();
    UserData user = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().getInfoFromEditForm(user);
    assertThat(user.getAllemails(), equalTo(mergeEmails(userInfoFromEditForm)));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  public String mergeEmails(UserData user) {
    return Arrays.asList(user.getEmail(), user.getEmail2(), user.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactEmailCheck::cleaned).collect(Collectors.joining("\n"));

  }
}
