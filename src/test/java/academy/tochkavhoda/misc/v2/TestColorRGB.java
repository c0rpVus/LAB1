// java
package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestColorRGB {

    @Test
    public void testBasicProperties() {
        ColorRGB c1 = new ColorRGB(10, 20, 30);
        assertEquals(10, c1.getR());
        assertEquals(20, c1.getG());
        assertEquals(30, c1.getB());

        c1.setR(255);
        c1.setG(-5); // должен зафиксироваться в 0
        assertEquals(255, c1.getR());
        assertEquals(0, c1.getG());

        ColorRGB c2 = new ColorRGB(255, 0, 30);
        assertEquals(0, c1.compareTo(c2)); // одинаковая суммарная яркость и компоненты
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }
}
