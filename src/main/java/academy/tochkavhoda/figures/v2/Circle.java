// java
package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Circle extends Figure implements academy.tochkavhoda.iface.v2.Resizable {

    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int x, int y, int radius) {
        this(new Point(x, y), radius);
    }

    public Circle(int radius) {
        this(new Point(0, 0), radius);
    }

    public Circle() {
        this(1);
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isInside(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        return dx * dx + dy * dy <= radius * radius;
    }

    @Override
    public Point getBasePoint() {
        return center;
    }

    @Override
    public void setBasePoint(Point point) {
        this.center = point;
    }

    @Override
    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        this.radius = (int) (this.radius * ratio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius &&
                Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
