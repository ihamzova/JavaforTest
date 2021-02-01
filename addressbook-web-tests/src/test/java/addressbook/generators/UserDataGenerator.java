package addressbook.generators;

import addressbook.model.UserData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserDataGenerator {
  @Parameter(names = "-c", description = "Users count")
  public int count;
  @Parameter(names = "-f", description = "Target file")
  public String file;
  @Parameter(names = "-d", description = "Data format")
  public String format;


  public static void main(String[] args) throws IOException {
    UserDataGenerator generator = new UserDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<UserData> users = generateUsers(count);
    if (format.equals("csv")) {
      saveAsCsv(users, new File(file));
    } else if (format.equals("json"))
      saveAsJson(users, new File(file));
    else {
      System.out.println("Unrecognized format");
    }
  }

  private void saveAsCsv(List<UserData> users, File file) throws IOException {
    System.out.println(new File(".").getAbsoluteFile());
    try (Writer writer = new FileWriter(file)) {
      for (UserData user : users) {
        writer.write(String.format(" %s; %s; %s\n",
                user.getName(),
                user.getSurname(),
                user.getAllemails(),
                user.getAllphones(),
                user.getaddress()));
      }
    }
  }

  public void saveAsJson(List<UserData> users, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(users);
    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }

  }


  public List<UserData> generateUsers(int count) {
    List<UserData> users = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      users.add(new UserData()
              .withName(String.format("Ирина %s", i))
              .withSurname(String.format("Кузнецова %s", i))
              .withaddress(String.format("Москва %s", i))
              .withEmail(String.format("email1%s@mail.com", i))
              .withEmail2(String.format("email2%s@mail.com", i))
              .withEmail3(String.format("email3%s@mail.com", i))
              .withHomenumber(String.format("111%s", i))
              .withMobilenumber(String.format("222%s", i))
              .withWorknumber(String.format("333%s", i)));
    }
    return users;


  }
}





