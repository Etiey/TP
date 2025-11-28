import java.util.ArrayList;
import java.util.Random;

class Union extends Shape {
  private ArrayList<Shape> shapes;

  public Union(ArrayList<Shape> shapes) {
    this.shapes=shapes;
  }

  @Override
  public Rectangle boundingBox() {
    if (shapes.isEmpty()) return null;
    Rectangle first = shapes.get(0).boundingBox();
    double minX = first.minX();
    double minY = first.minY();
    double maxX = first.maxX();
    double maxY = first.maxY();
    for (int i = 1; i < shapes.size(); i++) {
        Rectangle bb = shapes.get(i).boundingBox();
        if (bb.minX() < minX) minX = bb.minX();
        if (bb.minY() < minY) minY = bb.minY();
        if (bb.maxX() > maxX) maxX = bb.maxX();
        if (bb.maxY() > maxY) maxY = bb.maxY();
    }
    return new Rectangle(new Point(minX, minY), maxX - minX, maxY - minY);
  }

  @Override
  public boolean belongs(Point p) {
    for (Shape s : shapes) {
        if (s.belongs(p)) return true;
    }
    return false;
  }
}
