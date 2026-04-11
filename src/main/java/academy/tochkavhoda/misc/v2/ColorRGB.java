// java
package academy.tochkavhoda.misc.v2;

import java.io.Serializable;
import java.util.Objects;

public class ColorRGB implements Comparable<ColorRGB>, Serializable {

    private int r;
    private int g;
    private int b;

    public ColorRGB(int r, int g, int b) {
        this.r = clamp(r);
        this.g = clamp(g);
        this.b = clamp(b);
    }

    public ColorRGB() {
        this(0, 0, 0);
    }

    private int clamp(int v) {
        if (v < 0) return 0;
        if (v > 255) return 255;
        return v;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = clamp(r);
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = clamp(g);
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = clamp(b);
    }

    public int getBrightnessSum() {
        return r + g + b;
    }

    @Override
    public int compareTo(ColorRGB other) {
        int cmp = Integer.compare(this.getBrightnessSum(), other.getBrightnessSum());
        if (cmp != 0) return cmp;
        cmp = Integer.compare(this.r, other.r);
        if (cmp != 0) return cmp;
        cmp = Integer.compare(this.g, other.g);
        if (cmp != 0) return cmp;
        return Integer.compare(this.b, other.b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColorRGB)) return false;
        ColorRGB colorRGB = (ColorRGB) o;
        return r == colorRGB.r && g == colorRGB.g && b == colorRGB.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, g, b);
    }

    @Override
    public String toString() {
        return "ColorRGB{" + "r=" + r + ", g=" + g + ", b=" + b + '}';
    }
}
