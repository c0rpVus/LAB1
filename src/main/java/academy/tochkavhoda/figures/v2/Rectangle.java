package academy.tochkavhoda.figures.v2;

import java.util.Objects;

/**
 * Прямоугольник, заданный верхним левым и нижним правым углами.
 */
public class Rectangle extends Figure {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(int left, int top, int right, int bottom) {
        this.topLeft = new Point(left, top);
        this.bottomRight = new Point(right, bottom);
    }

    // Конструктор с точками
    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    // Конструктор по длине и ширине: topLeft = (0, -width), bottomRight = (length, 0)
    public Rectangle(int length, int width) {
        this.topLeft = new Point(0, -width);
        this.bottomRight = new Point(length, 0);
    }

    // Конструктор по умолчанию: 1x1
    public Rectangle() {
        this(1, 1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    // Публичные длина/ширина (по модулю)
    public int getLength() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    public int getWidth() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }

    @Override
    public double getArea() {
        return (double) getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    @Override
    public boolean isInside(int x, int y) {
        int left = Math.min(topLeft.getX(), bottomRight.getX());
        int right = Math.max(topLeft.getX(), bottomRight.getX());
        int top = Math.min(topLeft.getY(), bottomRight.getY());
        int bottom = Math.max(topLeft.getY(), bottomRight.getY());
        return x >= left && x <= right && y >= top && y <= bottom;
    }

    // Проверка целиком ли другой прямоугольник внутри этого
    public boolean isInside(Rectangle rectangle) {
        int aMinX = Math.min(this.topLeft.getX(), this.bottomRight.getX());
        int aMaxX = Math.max(this.topLeft.getX(), this.bottomRight.getX());
        int aMinY = Math.min(this.topLeft.getY(), this.bottomRight.getY());
        int aMaxY = Math.max(this.topLeft.getY(), this.bottomRight.getY());

        int bMinX = Math.min(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int bMaxX = Math.max(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int bMinY = Math.min(rectangle.topLeft.getY(), rectangle.bottomRight.getY());
        int bMaxY = Math.max(rectangle.topLeft.getY(), rectangle.bottomRight.getY());

        return bMinX >= aMinX && bMaxX <= aMaxX && bMinY >= aMinY && bMaxY <= aMaxY;
    }

    // Проверка пересечения
    public boolean isIntersects(Rectangle rectangle) {
        int aMinX = Math.min(this.topLeft.getX(), this.bottomRight.getX());
        int aMaxX = Math.max(this.topLeft.getX(), this.bottomRight.getX());
        int aMinY = Math.min(this.topLeft.getY(), this.bottomRight.getY());
        int aMaxY = Math.max(this.topLeft.getY(), this.bottomRight.getY());

        int bMinX = Math.min(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int bMaxX = Math.max(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int bMinY = Math.min(rectangle.topLeft.getY(), rectangle.bottomRight.getY());
        int bMaxY = Math.max(rectangle.topLeft.getY(), rectangle.bottomRight.getY());

        boolean intersectX = Math.max(aMinX, bMinX) <= Math.min(aMaxX, bMaxX);
        boolean intersectY = Math.max(aMinY, bMinY) <= Math.min(aMaxY, bMaxY);
        return intersectX && intersectY;
    }

    @Override
    public Point getBasePoint() {
        return topLeft;
    }

    @Override
    public void setBasePoint(Point point) {
        int w = getLength();
        int h = getWidth();
        this.topLeft = point;
        this.bottomRight = new Point(point.getX() + w, point.getY() + h);
    }

    @Override
    public void moveTo(int x, int y) {
        setBasePoint(new Point(x, y));
    }

    // Перегрузка для moveTo(Point)
    public void moveTo(Point point) {
        setBasePoint(point);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    // Изменение размера (масштаб относительно topLeft)
    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        this.bottomRight = new Point(this.topLeft.getX() + newLength, this.topLeft.getY() + newWidth);
    }

    // Растяжение по осям (от topLeft)
    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        this.bottomRight = new Point(this.topLeft.getX() + newLength, this.topLeft.getY() + newWidth);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
