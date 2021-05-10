package addressbook.tests;


import addressbook.model.UserData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HbConnectionTest {
  private SessionFactory sessionFactory;

  @BeforeClass(enabled = true)
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
      // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
      // so destroy it manually.
      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

//  @Test()
//  public void testHbConnection() {
//    Session session = sessionFactory.openSession();
//    session.beginTransaction();
//    List<GroupData> result = session.createQuery( "from GroupData" ).list();
//    session.getTransaction().commit();
//    session.close();
//    for (GroupData group : result ) {
//      System.out.println( group );
//      System.out.println(group.getUsers());
//    }
//  }}

  @Test
  public void testHbConnection() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData").list();
    session.getTransaction().commit();
    session.close();
    for (UserData user : result) {
      System.out.println(user);
      System.out.println(user.getGroups());
    }
  }
}

