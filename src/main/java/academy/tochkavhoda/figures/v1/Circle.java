package academy.tochkavhoda.figures.v1;


import java.util.Objects;

public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this(new Point(xCenter, yCenter), radius);
    }

    public Circle(int radius) {
        this(0, 0, radius);
    }

    public Circle() {
        this(0, 0, 1);
    }

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveTo(Point point) {
        this.center = point;
    }

    public void moveRel(int dx, int dy) {
        int newX = this.center.getX() + dx;
        int newY = this.center.getY() + dy;
        this.center = new Point(newX, newY);
    }

    public void resize(double ratio) {
        double newRadius = this.radius * ratio;
        this.radius = (int) newRadius; // Дробная часть отбрасывается
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(int x, int y) {
        int dx = x - this.center.getX();
        int dy = y - this.center.getY();
        int distanceSquared = dx * dx + dy * dy;
        return distanceSquared <= radius * radius;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public int getXCenter() {
        return center.getX();
    }

    public int getYCenter() {
        return center.getY();
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}
