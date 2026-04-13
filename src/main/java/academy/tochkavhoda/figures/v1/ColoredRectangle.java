package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle extends Rectangle {

    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredRectangle(int length, int width, int color) {
        Point topLeft = new Point(0, -width);
        Point bottomRight = new Point(length, 0);
        setTopLeft(topLeft);
        setBottomRight(bottomRight);
        this.color = color;
    }

    public ColoredRectangle(int color) {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this(1);
    }

    public Point getTopLeft() {
        return super.getTopLeft();
    }

    public Point getBottomRight() {
        return super.getBottomRight();
    }

    public int getColor() {
        return color;
    }

    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
    }

    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLength() {
        Point tl = getTopLeft();
        Point br = getBottomRight();
        return Math.abs(br.getX() - tl.getX());
    }

    public int getWidth() {
        Point tl = getTopLeft();
        Point br = getBottomRight();
        return Math.abs(br.getY() - tl.getY());
    }

    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        Point tl = getTopLeft();
        Point newBr = new Point(tl.getX() + newLength, tl.getY() + newWidth);
        setBottomRight(newBr);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        Point tl = getTopLeft();
        Point newBr = new Point(tl.getX() + newLength, tl.getY() + newWidth);
        setBottomRight(newBr);
    }

    public double getArea() {
        return (double) getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        Point tl = getTopLeft();
        Point br = getBottomRight();
        int minX = Math.min(tl.getX(), br.getX());
        int maxX = Math.max(tl.getX(), br.getX());
        int minY = Math.min(tl.getY(), br.getY());
        int maxY = Math.max(tl.getY(), br.getY());
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(ColoredRectangle rectangle) {
        Point a1 = this.getTopLeft();
        Point a2 = this.getBottomRight();
        Point b1 = rectangle.getTopLeft();
        Point b2 = rectangle.getBottomRight();

        int aMinX = Math.min(a1.getX(), a2.getX());
        int aMaxX = Math.max(a1.getX(), a2.getX());
        int aMinY = Math.min(a1.getY(), a2.getY());
        int aMaxY = Math.max(a1.getY(), a2.getY());

        int bMinX = Math.min(b1.getX(), b2.getX());
        int bMaxX = Math.max(b1.getX(), b2.getX());
        int bMinY = Math.min(b1.getY(), b2.getY());
        int bMaxY = Math.max(b1.getY(), b2.getY());

        boolean intersectX = Math.max(aMinX, bMinX) <= Math.min(aMaxX, bMaxX);
        boolean intersectY = Math.max(aMinY, bMinY) <= Math.min(aMaxY, bMaxY);
        return intersectX && intersectY;
    }

    public boolean isInside(ColoredRectangle rectangle) {
        Point a1 = this.getTopLeft();
        Point a2 = this.getBottomRight();
        Point b1 = rectangle.getTopLeft();
        Point b2 = rectangle.getBottomRight();

        int aMinX = Math.min(a1.getX(), a2.getX());
        int aMaxX = Math.max(a1.getX(), a2.getX());
        int aMinY = Math.min(a1.getY(), a2.getY());
        int aMaxY = Math.max(a1.getY(), a2.getY());

        int bMinX = Math.min(b1.getX(), b2.getX());
        int bMaxX = Math.max(b1.getX(), b2.getX());
        int bMinY = Math.min(b1.getY(), b2.getY());
        int bMaxY = Math.max(b1.getY(), b2.getY());

        return bMinX >= aMinX && bMaxX <= aMaxX && bMinY >= aMinY && bMaxY <= aMaxY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color &&
                Objects.equals(getTopLeft(), that.getTopLeft()) &&
                Objects.equals(getBottomRight(), that.getBottomRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopLeft(), getBottomRight(), color);
    }
}
