package addressbook.managers;

import addressbook.appmodel.GroupData;
import addressbook.appmodel.Groups;
import addressbook.appmodel.UserData;
import addressbook.appmodel.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {

      final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
              .configure() // configures settings from hibernate.cfg.xml
              .build();

        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

    }


public Groups groups (){
  Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData" ).list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);
  }

  public Users users (){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery( "from UserData" ).list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }



}


