// java
package academy.tochkavhoda.misc.v2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerson {

    @Test
    public void testCompareAndEquals() {
        Person p1 = new Person("Alice", 30);
        Person p2 = new Person("Bob", 25);
        Person p3 = new Person("Alice", 30);

        assertTrue(p1.compareTo(p2) < 0);
        assertEquals(0, p1.compareTo(p3));
        assertEquals(p1, p3);
        assertEquals(p1.hashCode(), p3.hashCode());

        p3.setAge(31);
        assertNotEquals(p1, p3);
    }
}
