package test.folder;

public class DZ2 {
  public static void main(String[] args) {
    Point point = new Point(3.4, 7.3);
    Point point2 = new Point(1.6, 9.2);
    System.out.println("Расстояние между точками = " + Point.distance(point, point2));
    System.out.println("Расстояние между точками = " + point.distance2(point2));


  }
}
