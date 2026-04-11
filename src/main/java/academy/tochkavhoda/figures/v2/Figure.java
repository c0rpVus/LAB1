// java
package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.HasArea;
import academy.tochkavhoda.iface.v2.Resizable;

/**
 * Базовый абстрактный класс для фигур.
 */
public abstract class Figure implements Movable, HasArea, Resizable {

    @Override
    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract boolean isInside(int x, int y);

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public abstract Point getBasePoint();

    public abstract void setBasePoint(Point point);
}
