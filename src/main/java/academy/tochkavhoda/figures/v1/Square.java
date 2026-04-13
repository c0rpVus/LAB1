package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        // левый нижний угол в (0,0) => topLeft = (0, -size)
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this(1);
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
        this.size = (int) (this.size * ratio);
    }

    public double getArea() {
        return (double) size * size;
    }

    public double getPerimeter() {
        return 4.0 * size;
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= topLeft.getX() + size
            && y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        int thisLeft = topLeft.getX();
        int thisRight = topLeft.getX() + size;
        int thisTop = topLeft.getY();
        int thisBottom = topLeft.getY() + size;

        int otherLeft = square.topLeft.getX();
        int otherRight = square.topLeft.getX() + square.size;
        int otherTop = square.topLeft.getY();
        int otherBottom = square.topLeft.getY() + square.size;

        return !(thisRight < otherLeft || otherRight < thisLeft || thisBottom < otherTop || otherBottom < thisTop);
    }

    public boolean isInside(Square square) {
        return square.topLeft.getX() >= this.topLeft.getX()
            && square.topLeft.getY() >= this.topLeft.getY()
            && square.topLeft.getX() + square.size <= this.topLeft.getX() + this.size
            && square.topLeft.getY() + square.size <= this.topLeft.getY() + this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size
                && topLeft.getX() == square.topLeft.getX()
                && topLeft.getY() == square.topLeft.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft.getX(), topLeft.getY(), size);
    }
}