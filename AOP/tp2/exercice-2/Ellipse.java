import java.util.Random;

// Axis Aligned Ellipses
class Ellipse extends Shape {

  private Point center;
  private double rx, ry;

  public Ellipse(Point p, double rx, double ry) {
    center=p;
    this.rx = rx;
    this.ry = ry;
  }

  @Override
  public Rectangle boundingBox() {
    Point bl = new Point(center.x - rx, center.y - ry);
    return new Rectangle(bl, 2 * rx, 2 * ry);
  }

  @Override
  public boolean belongs(Point p) {
    double dx = p.x - center.x;
    double dy = p.y - center.y;
    double termX = 0;
    double termY = 0;
    if (rx == 0) {
        if (Math.abs(dx) > 0) return false;
    } else {
        termX = (dx * dx) / (rx * rx);
    }
    if (ry == 0) {
        if (Math.abs(dy) > 0) return false;
    } else {
        termY = (dy * dy) / (ry * ry);
    }
    return termX + termY <= 1.0;
  }
}
