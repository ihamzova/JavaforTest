package mantis.appmanager;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void manageOverviewPage(){
    //click(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i"));
    // click(By.xpath("//a[contains(@href, '/mantisbt-2.24.4/manage_overview_page.php')]"));
    //click(By.id("menu-toggler"));
    //click(By.xpath("//li[6]/a/span"));
  }

  public void manageUserPage() {
    // click(By.linkText("Manage Users"));
    // driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[6]/a/i")).click();
    wd.get(app.getProperty("web.baseUrl")+ "manage_user_page.php");
  }
}
