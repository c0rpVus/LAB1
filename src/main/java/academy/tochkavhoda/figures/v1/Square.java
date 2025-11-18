package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive");
        }
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this.topLeft = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        this.topLeft = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.topLeft = new Point(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ratio must be positive");
        }
        this.size = (int)(size * ratio);
        if (this.size <= 0) {
            this.size = 1;
        }
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX() + size &&
                y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        return !(this.getBottomRight().getX() < square.getTopLeft().getX() ||
                this.getTopLeft().getX() > square.getBottomRight().getX() ||
                this.getBottomRight().getY() < square.getTopLeft().getY() ||
                this.getTopLeft().getY() > square.getBottomRight().getY());
    }

    public boolean isInside(Square square) {
        return this.isInside(square.getTopLeft()) &&
                this.isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }

    @Override
    public String toString() {
        return "Square{" +
                "topLeft=" + topLeft +
                ", size=" + size +
                '}';
    }
}