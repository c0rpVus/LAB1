package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private Color color;

    // Исправленные конструкторы с Color
    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        this(0, -width, length, 0, color);
    }

    public ColoredRectangle(Color color) throws ColorException {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this.color = Color.RED;
    }

    // Конструкторы с String (уже правильные)
    public ColoredRectangle(Point leftTop, Point rightBottom, String colorString) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String colorString) throws ColorException {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), colorString);
    }

    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        this(0, -width, length, 0, colorString);
    }

    public ColoredRectangle(String colorString) throws ColorException {
        this(1, 1, colorString);
    }

    @Override
    public Color getColor() {
        return color;
    }

    // Исправленный метод setColor с проверкой на null
    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = Color.colorFromString(colorString);
    }

    /**Определяет, пересекается ли ColoredRectangle с другим ColoredRectangle.
     Считается, что ColoredRectangle пересекаются, если у них есть хоть одна общая точка.*/
    public boolean isIntersects(ColoredRectangle rectangle) {
        return super.isIntersects(rectangle);
    }

    /**Определяет, лежит ли ColoredRectangle целиком внутри текущего ColoredRectangle.*/
    public boolean isInside(ColoredRectangle rectangle) {
        return super.isInside(rectangle);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}