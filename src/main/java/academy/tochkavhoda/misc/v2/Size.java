// java
package academy.tochkavhoda.misc.v2;

import java.io.Serializable;
import java.util.Objects;

public class Size implements Cloneable, Serializable {

    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = Math.abs(width);
        this.height = Math.abs(height);
    }

    public Size(int side) {
        this(side, side);
    }

    public Size() {
        this(1, 1);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = Math.abs(width);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = Math.abs(height);
    }

    public int getArea() {
        return width * height;
    }

    @Override
    public Size clone() {
        try {
            return (Size) super.clone();
        } catch (CloneNotSupportedException e) {
            // не должно случиться, так как мы реализуем Cloneable
            return new Size(this.width, this.height);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Size)) return false;
        Size size = (Size) o;
        return width == size.width && height == size.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Size{" + "width=" + width + ", height=" + height + '}';
    }
}
