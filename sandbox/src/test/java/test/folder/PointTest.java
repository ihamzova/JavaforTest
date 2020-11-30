package test.folder;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {
  @Test
  public void test() {
    Point point = new Point(3.1, 8.3);
    Point point2 = new Point(4.4, 7.2);
    Assert.assertEquals(point.distance2(point2), 1.7029386365926407);
  }
}
