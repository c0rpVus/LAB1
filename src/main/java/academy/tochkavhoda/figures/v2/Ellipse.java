// java
package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Ellipse extends Figure {

    private Point center;
    private int xAxis; // диаметр по X
    private int yAxis; // диаметр по Y

    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = Math.abs(xAxis);
        this.yAxis = Math.abs(yAxis);
    }

    public Ellipse(int centerX, int centerY, int xAxis, int yAxis) {
        this(new Point(centerX, centerY), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse(int axis) {
        this(axis, axis);
    }

    public Ellipse() {
        this(1);
    }

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = Math.abs(xAxis);
    }

    public void setYAxis(int yAxis) {
        this.yAxis = Math.abs(yAxis);
    }

    @Override
    public double getArea() {
        // полуоси = диаметр / 2
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    @Override
    public double getPerimeter() {
        // используем приближение 2*pi*sqrt((a^2 + b^2)/2), где a,b - полуоси
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return 2.0 * Math.PI * Math.sqrt((a * a + b * b) / 2.0);
    }

    @Override
    public boolean isInside(int x, int y) {
        double dx = x - center.getX();
        double dy = y - center.getY();
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        if (a == 0 || b == 0) return false;
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1.0;
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
        this.xAxis = (int) (this.xAxis * ratio);
        this.yAxis = (int) (this.yAxis * ratio);
        if (this.xAxis < 0) this.xAxis = -this.xAxis;
        if (this.yAxis < 0) this.yAxis = -this.yAxis;
    }

    public void stretch(double xRatio, double yRatio) {
        this.xAxis = (int) (this.xAxis * xRatio);
        this.yAxis = (int) (this.yAxis * yRatio);
        if (this.xAxis < 0) this.xAxis = -this.xAxis;
        if (this.yAxis < 0) this.yAxis = -this.yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}
