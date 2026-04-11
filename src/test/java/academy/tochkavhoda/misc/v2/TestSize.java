// java
package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSize {

    @Test
    public void testCloneAndArea() {
        Size s1 = new Size(3, 4);
        assertEquals(12, s1.getArea());
        Size s2 = s1.clone();
        assertEquals(s1, s2);
        assertNotSame(s1, s2);

        s2.setWidth(5);
        assertEquals(3, s1.getWidth());
        assertEquals(5, s2.getWidth());
        assertNotEquals(s1, s2);
    }

    @Test
    public void testNegativeInputsBecomePositive() {
        Size s = new Size(-10, -20);
        assertEquals(10, s.getWidth());
        assertEquals(20, s.getHeight());
    }
}
