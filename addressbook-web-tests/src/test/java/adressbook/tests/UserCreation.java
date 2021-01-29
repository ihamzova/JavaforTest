package adressbook.tests;

import adressbook.model.GroupData;
import adressbook.model.UserData;
import adressbook.model.Users;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreation extends Testbase {


  @DataProvider

  public Iterator<Object[]> validUsersFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader((new FileReader("src/test/resources/users.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        String[] split = line.split(";");
        json += line;
        line = reader.readLine();

      }
      Gson gson = new Gson();
      List<UserData> users = gson.fromJson(json, new TypeToken<List<UserData>>() {
      }.getType());
      return users.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

    }
  }


  @Test(dataProvider = "validUsersFromJson")
  public void testCreateNewUser(UserData user) throws Exception {
    app.goTo().homePage();
    Users before = app.user().all();
    File photo = new File("src/test/resources/Pic2.jpeg");
    app.user().сreateUser(user);
    app.goTo().homePage();
    Users after = app.user().all();
    assertThat(after.size(), equalTo(before.size() + 1));
    assertThat(after, equalTo(before.withadded(user.withtId(after.stream().mapToInt((u) -> u.getId()).max().getAsInt()))));
  }

  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/Pic2.jpeg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }

}

