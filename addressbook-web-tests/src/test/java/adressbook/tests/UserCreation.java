package adressbook.tests;
import adressbook.model.UserData;
import adressbook.model.Users;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreation extends Testbase {


  @Test
  public void testCreateNewUser() throws Exception {
    app.goTo().homePage();
    Users before = app.user().all();
    File photo = new File("src/test/resources/Pic2.jpeg");
    UserData user = new UserData().withName("Василий").withSurname("Петроа").withPhoto(photo);
    app.user().сreateUser(user);
    app.goTo().homePage();
    Users after = app.user().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withadded(user.withtId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));
  }
@Test
  public void testCurrentDir(){
    File currentDir = new File(".");
  System.out.println(currentDir.getAbsolutePath());
  File photo = new File("src/test/resources/Pic2.jpeg");
  System.out.println(photo.getAbsolutePath());
  System.out.println(photo.exists());
}

}

