package academy.tochkavhoda.iface.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;

public interface Colored {
    Color getColor();
    void setColor(Color color) throws ColorException;

    /**
     * Устанавливает цвет по текстовой строке
     * @param colorString строковое представление цвета
     * @throws ColorException если передана недопустимая строка (null или несоответствие цвету)
     */
    void setColor(String colorString) throws ColorException;
}