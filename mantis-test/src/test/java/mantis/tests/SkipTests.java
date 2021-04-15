package mantis.tests;

import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class SkipTests extends Testbase {

  @Test
  public void testSkip() throws RemoteException, ServiceException, MalformedURLException {
    int issueId = 2;
    skipIfNotFixed(issueId);
    System.out.println("NOT Ignored because of issue " + issueId);
  }
}