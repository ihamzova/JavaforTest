package addressbook.tests;

import addressbook.appmodel.UserData;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneCheck extends Testbase {

  @Test
  public void testContactPhone() {
    app.goTo().homePage();
    UserData userData = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().getInfoFromEditForm(userData);
    assertThat(userData.getAllphones(), equalTo(mergePhones(userInfoFromEditForm)));

  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");

  }

  public String mergePhones(UserData userData) {
    return Arrays.asList(userData.getHomephones(), userData.getWorkphones(), userData.getMobilephones())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactPhoneCheck::cleaned)
            .collect(Collectors.joining("\n"));
  }

}
