import java.util.Random;

public class Main{

  static int pass = 0;
  static int fail = 0;

  static void test_int (String name, int actual, int expected){
    if (actual == expected) {
      pass++;
      System.out.println(name + " PASS");
    } else {
      fail++;
      System.out.println(name + " FAIL: '" + actual + "' instead of '" + expected + "'");
    }
  }

  static void test_string (String name, Object actual, String expected){
    if (!(actual==null) && actual.toString().equals(expected)) {
      pass++;
      System.out.println(name + " PASS");
    } else {
      fail++;
      System.out.println(name + " FAIL: '" + actual + "' instead of '" + expected + "'");
    }
  }

  static void test_double (String name, double actual, double expected){
    if (actual == expected) {
      pass++;
      System.out.println(name + " PASS");
    } else {
      fail++;
      System.out.println(name + " FAIL: " + actual + " instead of " + expected);
    }
  }

  public static void main(String[] args){
    Point p1 = new Point (0,0);
    Point p2 = new Point (0,1);
    Point p3 = new Point (1,1);
    Point p4 = new Point (1,0);
    Point v1_2 = p1.vector(p2);
    Point mid1_2 = p1.center(p2);
    Point p5 = p2.translate(p2);
    Point p6 = p2.scal(2);

    Triangle t1 = new Triangle(p1,p2,p3);
    Triangle t2 = new Triangle(p1,p5,p3);
    Triangle t3 = new Triangle(p1,p1,p1);
    Point[] pts1 = {p1, p2, p3, p4};
    Polygon poly1 = new Polygon(pts1);
    Point[] pts2 = {p1, p5, p3, p4};
    Polygon poly2 = new Polygon(pts2);
    Point[] pts3 = {p1, p1, p1};
    Polygon poly3 = new Polygon(pts3);

    Random gen = new Random();

    test_string ("point creation", p1, "0.0 0.0");
    test_string ("vector creation", v1_2, "0.0 1.0");
    test_string ("center", mid1_2, "0.0 0.5");
    test_string ("translation", p5, "0.0 2.0");
    test_string ("scal", p6, "0.0 2.0");
    test_double ("det 1", p1.det(p3), 0.0);
    test_double ("det 2", p4.det(p3), 1.0);
    test_double ("triangle volume 1", t1.area(), 0.5);
    test_double ("triangle volume 2", t2.area(), 1.);
    test_string ("triangle random", t3.random(gen), "0.0 0.0");
    test_double ("polygon volume 1", poly1.area(), 1.0);
    test_double ("polygon volume 2", poly2.area(), 1.5);
    test_string ("polygon random", poly3.random(gen), "0.0 0.0");
    test_double ("triangle volume 3", t3.area(), 0.);
    test_double ("polygon volume 3", poly3.area(), 0.);

    Triangle t4 = new Triangle(new Point (0,0), new Point(1,1), new Point(1,0));
    int in_t = 0;
    Point pp;
    for (int i=0; i<100; i++){
      pp=t4.random(gen);
      if(pp != null && pp.x <= 1 && pp.y <= 1 && pp.x >= 0 && pp.y >= 0 && pp.x >= pp.y) in_t++;
    }
    test_int ("Inside Triangle", in_t, 100);
    Point[] pts4 = {new Point (0,0), new Point(0,1), new Point(1,1), new Point(1,0)};
    Polygon poly4 = new Polygon(pts4);
    int in_p = 0;
    for (int i=0; i<100; i++){
      pp=poly4.random(gen);
      if(pp != null && pp.x <= 1 && pp.y <= 1 && pp.x >= 0 && pp.y >= 0) in_p++;
    }
    test_int ("Inside poly", in_p, 100);
    System.out.println(pass + "/" + (pass+fail));
  }
}
