package mantis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import mantis.model.Issue;
import mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends Testbase {

  @BeforeMethod
  public void ensureIfIssueFixed() throws RemoteException, ServiceException, MalformedURLException {
    int issueId = 2;
    skipIfNotFixed(issueId);
  }

  @Test
  public void testsGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue()
            .withSummary("Test issue1").withDescription("Test issue2 Description")
            .withProject(projects.iterator().next());
    Issue createdIssue = app.soap().addIssue(issue);
    Assert.assertEquals(issue.getSummary(), createdIssue.getSummary());
  }

}