package test.folder;

public class Point {

  double x;
  double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }


  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y));
  }

  public double distance2(Point p2) {
    return Math.sqrt((p2.x - this.x) * (p2.x - this.x)) + ((p2.y - this.y) * (p2.y - this.y));
  }
}
