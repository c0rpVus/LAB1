// java
package academy.tochkavhoda.figures.v2;

import java.util.Objects;

public class Square extends Rectangle {

    public Square(Point topLeft, int side) {
        super(topLeft, new Point(topLeft.getX() + side, topLeft.getY() + side));
    }

    public Square(int x, int y, int side) {
        this(new Point(x, y), side);
    }

    public Square(int side) {
        // верхний левый угол по умолчанию должен быть (0, -side)
        this(new Point(0, -Math.abs(side)), Math.abs(side));
    }

    public Square() {
        this(1);
    }

    public int getLength() {
        Point tl = getTopLeft();
        Point br = getBottomRight();
        return Math.abs(br.getX() - tl.getX());
    }

    public void setLength(int length) {
        if (length < 0) length = -length;
        Point tl = getTopLeft();
        // напрямую устанавливаем bottomRight через super, чтобы не задеть переопределённый setBottomRight
        super.setBottomRight(new Point(tl.getX() + length, tl.getY() + length));
    }

    @Override
    public void setTopLeft(Point topLeft) {
        int length = getLength();
        super.setTopLeft(topLeft);
        super.setBottomRight(new Point(topLeft.getX() + length, topLeft.getY() + length));
    }

    @Override
    public void setBottomRight(Point bottomRight) {
        int length = getLength();
        if (length == 0) {
            // если длина ещё не установлена, вычисляем по разнице
            length = Math.abs(bottomRight.getX() - getTopLeft().getX());
        }
        super.setBottomRight(bottomRight);
        super.setTopLeft(new Point(bottomRight.getX() - length, bottomRight.getY() - length));
    }

    @Override
    public void moveRel(int dx, int dy) {
        super.moveRel(dx, dy);
    }

    @Override
    public void moveTo(int x, int y) {
        // устанавливаем верхний левый в нужную позицию
        setTopLeft(new Point(x, y));
    }

    @Override
    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        setLength(newLength);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return getLength() == square.getLength() &&
                Objects.equals(getTopLeft(), square.getTopLeft());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTopLeft(), getLength());
    }
}
