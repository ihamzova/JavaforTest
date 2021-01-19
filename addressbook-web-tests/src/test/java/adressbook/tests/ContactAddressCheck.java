package adressbook.tests;


import adressbook.model.UserData;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressCheck extends Testbase {
  @Test
  public void testContactAddress(){
    app.goTo().homePage();
    UserData userData = app.user().all().iterator().next();
    UserData userInfoFromEditForm = app.user().getInfoFromEditForm(userData);
    assertThat(userData.getaddress(), equalTo(userInfoFromEditForm.getaddress()));
  }
}
