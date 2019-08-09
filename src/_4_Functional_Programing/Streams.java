package _4_Functional_Programing;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {
        Stream<String> empty = Stream.empty();              // count = 0
        Stream<Integer> singleElement = Stream.of(1);       // count = 1
        Stream<Integer> fromArray = Stream.of(1, 2, 3);     // count = 2

        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)
                .sorted()
                .forEach(System.out::println);

        asList();
        count();

    }

    public static void asList() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> fromList = list.stream();
        Stream<String> fromListParallel = list.parallelStream();

//        Stream<Double> randoms = Stream.generate(Math::random);
//        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2); // Infinite stream
    }

    public static void count() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3
    }

    public static void minAndMax() {
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min((s1, s2) -> s1.length()- s2.length());
        Optional<String> min2 = s.min(Comparator.comparingInt(String::length));

        min.ifPresent(System.out::println); // ape

        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); // false
    }

    public static void findAnyAndFindFirst() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s.findAny().ifPresent(System.out::println);         // monkey
        infinite.findAny().ifPresent(System.out::println);  // chimp

        s.findFirst().ifPresent(System.out::println);  // monkey

    }

    public static void match() {
        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred));   // true
        System.out.println(list.stream().allMatch(pred));   // false
        System.out.println(list.stream().noneMatch(pred));  // false
        System.out.println(infinite.anyMatch(pred));        // true, always because only one element
    }

    public static void forEach() {
        Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
        s.forEach(System.out::print); // MonkeyGorillaBonobo

//        Stream s = Stream.of(1);
//        for (Integer i: s) {} // DOES NOT COMPILE
    }

    public static void reduce() {

        String[] array = new String[] { "w", "o", "l", "f" };
        String result = "";
        for (String s: array) result = result + s;
        System.out.println(result);

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s, c) -> s + c);
        System.out.println(word);                                   // wolf

        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        word = stream.reduce("", String::concat);
        System.out.println(word); // wolf

        Stream<Integer> stream3 = Stream.of(3, 5, 6);
        System.out.println(stream3.reduce(1, (a, b) -> a*b));

        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        empty.reduce(op).ifPresent(System.out::print);          // no output
        oneElement.reduce(op).ifPresent(System.out::print);     // 3
        threeElements.reduce(op).ifPresent(System.out::print);  // 90

        BinaryOperator<Integer> op1 = (a, b) -> a * b;
        Stream<Integer> stream4 = Stream.of(3, 5, 6);
        System.out.println(stream4.reduce(1, op, op));   // 90
    }

    public static void collect() { //mutable reduction

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        StringBuilder word = stream.collect(StringBuilder::new,
                StringBuilder::append, StringBuilder::append);      // good for parallel

        TreeSet<String> set = Stream.of("w", "o", "l", "f").collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

        // Use of Collectors
        TreeSet<String> set2 = Stream.of("w", "o", "l", "f").collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set2); // [f, l, o, w]

        Set<String> set3 = Stream.of("w", "o", "l", "f").collect(Collectors.toSet());
        System.out.println(set3); // [f, w, l, o]

    }

    public static void filter() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m"))
                .forEach(System.out::print); // monkey
    }

    public static void distinct() {
        Stream<String> s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct()
                .forEach(System.out::print); // duckgoose
    }
    public static void limitAndSkip() {
        Stream<Integer> s = Stream.iterate(1, n -> n + 1);
        s.skip(5)
                .limit(2)
                .forEach(System.out::print); // 67

    }
    public static void map() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length)
                .forEach(System.out::print); // 676

    }
    public static void flatMap() { //  makes any elements it contains top-level elements in a single stream.
                                   // This is helpful when you want to remove empty
                                   // elements from a stream or you want to combine a stream of lists.

        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream())
                .forEach(System.out::println); // Bonobo Mama Gorilla Baby Gorilla
    }

    public static void sorted() {
        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted().forEach(System.out::print); // bear-brown

        Stream<String> s2 = Stream.of("brown bear-", "grizzly-");
        s2.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-

//        s.sorted(Comparator::reverseOrder); // DOES NOT COMPILE
    }

    public static void peek() {
        Stream<String> stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g"))
                .peek(System.out::println).count();     // grizzly
        System.out.println(count);                      // 1
    }

    public static void example1() {
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name: list) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        Iterator<String> iter = filtered.iterator();
        if (iter.hasNext()) System.out.println(iter.next());
        if (iter.hasNext()) System.out.println(iter.next());
    }

    public static void example2() {
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");

        list.stream().filter(n -> n.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);
    }

}
