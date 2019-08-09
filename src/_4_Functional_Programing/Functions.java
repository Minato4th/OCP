package _4_Functional_Programing;

import java.util.function.BiFunction;
import java.util.function.Function;

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class Functions {

    public static void main(String[] args) {
        Function<String, Integer> f1 = String::length;
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5
    }

    public static void example() {
        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("baby ", "chick")); // baby chick
        System.out.println(b2.apply("baby ", "chick")); // baby chick
    }

    public static void example1() {
        TriFunction<String, String, String, String> b2 = (string, toAdd, toAdd2) -> {
            string.concat(toAdd);
            string.concat(toAdd2);
            return string;
        };

        System.out.println(b2.apply("baby ", "chick", "4")); // baby chick 4
    }
}
