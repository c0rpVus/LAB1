package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {
    private Point center;
    private int xAxis; // full length по X
    private int yAxis; // full length по Y

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        this(1, 1);
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        this.xAxis = (int) (this.xAxis * ratio);
        this.yAxis = (int) (this.yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        this.xAxis = (int) (this.xAxis * xRatio);
        this.yAxis = (int) (this.yAxis * yRatio);
    }

    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    public double getPerimeter() {
        return 2.0 * Math.PI * Math.sqrt((xAxis * (double) xAxis + yAxis * (double) yAxis) / 8.0);
    }

    public boolean isInside(int x, int y) {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        double dx = x - center.getX();
        double dy = y - center.getY();
        double val = (dx * dx) / (a * a) + (dy * dy) / (b * b);
        return val <= 1.0;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis
                && yAxis == ellipse.yAxis
                && center.getX() == ellipse.center.getX()
                && center.getY() == ellipse.center.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(center.getX(), center.getY(), xAxis, yAxis);
    }
}