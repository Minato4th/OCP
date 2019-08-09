package _7_Concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args) {

    }

    public static void parallel() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        Stream<Integer> parallelStream = stream.parallel();

    }

    public static void parallelStream() {
        Stream<Integer> parallelStream2 = Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream();
    }

    public static void parallelExample() {
        Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream()
                .forEach(s -> System.out.print(s + " "));     //1 2 3 4 5 6

        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEach(s -> System.out.print(s + " "));     // maybe 4 1 6 5 2 3

        Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .forEachOrdered(s -> System.out.print(s + " "));  //1 2 3 4 5 6

    }

    public static void independentExecuting() {

        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);              //faster that non parallel

        Arrays.asList("jackal", "kangaroo", "lemur")
                .parallelStream()
                .map(s -> {
                    System.out.println(s);
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

    }

    public static void stateful() {

        List<Integer> data = Collections.synchronizedList(new ArrayList<>());
        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream()
                .map(i -> {
                    data.add(i);
                    return i;
                })                                      // AVOID STATEFUL LAMBDA EXPRESSIONS!
                .forEachOrdered(i -> System.out.print(i + " "));
        System.out.println();
        for (Integer e : data) {
            System.out.print(e + " ");
        }
    }

    public static void parallelReduction() {

        System.out.print(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());

        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .stream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));               //wolf

        System.out.println(Arrays.asList('w', 'o', 'l', 'f')
                .parallelStream()
                .reduce("",(c,s1) -> c + s1,
                        (s2,s3) -> s2 + s3));               // wolf

        System.out.println(Arrays.asList(1,2,3,4,5,6)
                .parallelStream()
                .reduce(0,(a,b) -> (a-b))); // NOT AN ASSOCIATIVE ACCUMULATOR -21, 3,


        System.out.println(Arrays.asList("w","o","l","f")
                .parallelStream()
                .reduce("X",String::concat)); //XwXoXlXf
    }

    public static void collect() {

        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add,
                Set::addAll);
        System.out.println(set); // [f, l, o, w]

        Stream<String> stream2 = Stream.of("w", "o", "l", "f").parallel();
        Set<String> set2 = stream2.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o]

    }

    public static void parallelReductionCollect(){
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, String> map = ohMy
                .collect(Collectors.toConcurrentMap(String::length, k -> k,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println(map);                    // {5=lions,bears, 6=tigers}
        System.out.println(map.getClass());         // java.util.concurrent.ConcurrentHashMap

        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears").parallel();
        ConcurrentMap<Integer, List<String>> map1 = ohMy1
                .collect(Collectors.groupingByConcurrent(String::length));
        System.out.println(map1);                   // {5=[lions, bears], 6=[tigers]}
    }

//    Arrays.asList(1,2,3,4,5,6).stream().unordered();
//    Arrays.asList(1,2,3,4,5,6).stream().unordered().parallel();
}
