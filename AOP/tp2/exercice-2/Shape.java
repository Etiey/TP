import java.util.Random;

abstract class Shape {
    public abstract Rectangle boundingBox();
    public abstract boolean belongs(Point p);

  public Point random(Random gen, int nb) {
	Rectangle bb = this.boundingBox();
        double minX = bb.minX();
        double minY = bb.minY();
        double w = bb.maxX() - minX;
        double h = bb.maxY() - minY;
        for (int i = 0; i < nb; i++) {
            double x = minX + w * gen.nextDouble();
            double y = minY + h * gen.nextDouble();
            Point p = new Point(x, y);
            if (this.belongs(p)) {
                return p;
            }
        }
      return null;
    }
}
