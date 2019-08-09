package _3_Generic_and_Collections;

import java.util.*;

public class SearchingAndSorting {
    static class Rabbit {
        int id;
    }

    public static void main(String[] args) {
        List<Rabbit> rabbits = new ArrayList<>();
        rabbits.add(new Rabbit());
//        Collections.sort(rabbits); // DOES NOT COMPILE

        Comparator<Rabbit> c = (r1, r2) -> r1.id - r2.id;
        Collections.sort(rabbits, c);

        List<String> names = Arrays.asList("Fluffy", "Hoppy");
        Comparator<String> b = Comparator.reverseOrder();
        int index = Collections.binarySearch(names, "Hoppy", b);
        System.out.println(index);

        Set<Rabbit> rabbit = new TreeSet<>();
        rabbit.add(new Rabbit()); // throws an exception

    }
}
