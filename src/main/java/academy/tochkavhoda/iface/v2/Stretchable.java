package academy.tochkavhoda.iface.v2;

public interface Stretchable extends Resizable {
    void stretch(double xRatio, double yRatio);

    @Override
    default void resize(double ratio) {
        stretch(ratio, ratio);
    }
}
