package _4_Functional_Programing;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {

    public static void main(String[] args) {

        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie");
        c2.accept("Annie");

    }

    public static void example() {
        Map<String, Integer> map = new HashMap<>();

        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        b1.accept("chicken", 7);
        b2.accept("chick", 1);

        System.out.println(map);
    }

    public static void example1() {
        Map<String, String> map = new HashMap<>();

        BiConsumer<String, String> b1 = map::put;
        BiConsumer<String, String> b2 = (k, v) -> map.put(k, v);

        b1.accept("chicken", "Cluck");
        b2.accept("chick", "Tweep");

        System.out.println(map);

    }
}
