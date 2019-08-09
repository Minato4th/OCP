package _3_Generic_and_Collections;

import java.util.ArrayList;
import java.util.List;

public class WildCards {

    public static void main(String[] args) {

    }

    public static void unboundedWildcards() {
        List<String> keywords = new ArrayList<>();
        keywords.add("java");
        printList(keywords);
    }

    private static void printList(List<?> list) {
        for (Object x: list) System.out.println(x);
    }

    public static void upperBoundedWildcards() {
//        ArrayList<Number> list = new ArrayList<Integer>(); // DOES NOT COMPILE
        List<? extends Number> list = new ArrayList<Integer>();


    }

    public static long total(List<? extends Number> list) {
        long count = 0;
        for (Number number: list)
            count += number.longValue();
        return count;
    }
}
