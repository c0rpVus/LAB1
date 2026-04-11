// java
package academy.tochkavhoda.misc.v2;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name == null ? "" : name;
        this.age = Math.max(0, age);
    }

    public Person(String name) {
        this(name, 0);
    }

    public Person() {
        this("", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(0, age);
    }

    @Override
    public int compareTo(Person o) {
        int cmp = this.name.compareTo(o.name);
        if (cmp != 0) return cmp;
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
