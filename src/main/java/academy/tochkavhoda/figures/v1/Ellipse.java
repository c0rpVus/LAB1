package academy.tochkavhoda.figures.v1;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        if (xAxis <= 0 || yAxis <= 0) {
            throw new IllegalArgumentException("Axis sizes must be positive");
        }
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        if (xAxis <= 0 || yAxis <= 0) {
            throw new IllegalArgumentException("Axis sizes must be positive");
        }
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        if (xAxis <= 0 || yAxis <= 0) {
            throw new IllegalArgumentException("Axis sizes must be positive");
        }
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
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
        if (xAxis <= 0) {
            throw new IllegalArgumentException("X axis size must be positive");
        }
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        if (yAxis <= 0) {
            throw new IllegalArgumentException("Y axis size must be positive");
        }
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
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ratio must be positive");
        }
        this.xAxis = (int)(xAxis * ratio);
        this.yAxis = (int)(yAxis * ratio);

        // Гарантируем минимальный размер
        if (this.xAxis <= 0) this.xAxis = 1;
        if (this.yAxis <= 0) this.yAxis = 1;
    }

    public void stretch(double xRatio, double yRatio) {
        if (xRatio <= 0 || yRatio <= 0) {
            throw new IllegalArgumentException("Ratios must be positive");
        }
        this.xAxis = (int)(xAxis * xRatio);
        this.yAxis = (int)(yAxis * yRatio);

        // Гарантируем минимальный размер
        if (this.xAxis <= 0) this.xAxis = 1;
        if (this.yAxis <= 0) this.yAxis = 1;
    }

    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }


    public boolean isInside(int x, int y) {
        double dx = x - center.getX();
        double dy = y - center.getY();
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;

        // Уравнение эллипса: (x²/a²) + (y²/b²) <= 1
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1.0;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public int getX() {
        return center.getX();
    }

    public int getY() {
        return center.getY();
    }

    public Rectangle getBoundingBox() {
        int xLeft = center.getX() - xAxis / 2;
        int yTop = center.getY() + yAxis / 2;
        int xRight = center.getX() + xAxis / 2;
        int yBottom = center.getY() - yAxis / 2;
        return new Rectangle(xLeft, yTop, xRight, yBottom);
    }

    @Override
    public String toString() {
        return "Ellipse[center=(" + center.getX() + "," + center.getY() +
                "), xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ellipse ellipse = (Ellipse) obj;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                center.equals(ellipse.center);
    }

    @Override
    public int hashCode() {
        return 31 * center.hashCode() + 17 * xAxis + yAxis;
    }
}
