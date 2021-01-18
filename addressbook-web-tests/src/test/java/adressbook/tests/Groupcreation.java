package adressbook.tests;

import adressbook.model.GroupData;
import adressbook.model.Groups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class Groupcreation extends Testbase {

  @DataProvider

  public Iterator<Object[]> validGroups() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader((new FileReader("src/test/resources/groups.csv")));
    String line = reader.readLine();
    while (line != null) {
    String[] split = line.split(";");
      list.add(new Object[]{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
      line = reader.readLine();

    }
    return list.iterator();
  }

    @Test(dataProvider = "validGroups")
    public void testCreateNewGroup (GroupData group) throws Exception {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().getGroupCount(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(before.withadded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

  }
