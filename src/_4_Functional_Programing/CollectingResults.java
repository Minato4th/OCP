package _4_Functional_Programing;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static void main(String[] args) {

    }

    public static void joining() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result); // lions, tigers, bears
    }

    public static void averagingInt() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result);      // 5.333333333333333
    }


    public static void toMap() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map1 = ohMy1.collect(Collectors.toMap(String::length, k -> k)); // BAD IllegalStateException:


        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map2 = ohMy2.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map2);                       // {5=lions,bears, 6=tigers}
        System.out.println(map2.getClass());            // class. java.util.HashMap


        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map3 = ohMy3.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map3);                   // {5=lions,bears, 6=tigers}
        System.out.println(map3.getClass());        // class. java.util.TreeMap
    }

    public static void toCollection() {
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result2 = ohMy1.filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result2); // [tigers]
    }

    public static void groupingBy() {

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map1 = ohMy1.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toSet()));
        System.out.println(map1); // {5=[lions, bears], 6=[tigers]}

    }

    public static void toSet() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map1 = ohMy1.collect(
                Collectors.partitioningBy(s -> s.length() <= 7, Collectors.toSet()));
        System.out.println(map1);// {false=[], true=[lions, tigers, bears]}
    }

    public static void toList() {

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map);

    }

    public static void partitioningBy() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map); // {false=[tigers], true=[lions, bears]}

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map1 = ohMy1.collect(
                Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println(map1); // {false=[], true=[lions, tigers, bears]}
    }

    public static void counting() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = ohMy.collect(Collectors.groupingBy(
                String::length, Collectors.counting()));
        System.out.println(map); // {5=2, 6=1}
    }

    public static void naturalOrder() {
//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map = ohMy.collect(
//                Collectors.groupingBy(String::length,Collectors.mapping(s -> s.charAt(0),Collectors.minBy(Comparator.naturalOrder()))));
//        System.out.println(map); // {5=Optional[b], 6=Optional[t]}
    }

}
