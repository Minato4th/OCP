package _3_Generic_and_Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableExample implements Comparable<ComparableExample> {

    private String name;

    public ComparableExample(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(ComparableExample o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String[] args) {
        List<ComparableExample> ex = new ArrayList<>();
        ex.add(new ComparableExample("xz"));
        ex.add(new ComparableExample("some"));

        Collections.sort(ex);

        ex.forEach(System.out::println);

    }
}

class AnotherExample implements Comparable<AnotherExample>{

    public int id;

    @Override
    public int compareTo(AnotherExample o) {
        return id - o.id;
    }
}
