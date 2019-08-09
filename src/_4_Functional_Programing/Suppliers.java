package _4_Functional_Programing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Supplier;

public class Suppliers {

    public static void main(String[] args) {
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

    }

    public static void example() {
        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        System.out.println(s1.get());
        System.out.println(s2.get());
    }

    public static void example1() {
        Supplier<ArrayList<String>> s1 = ArrayList<String>::new;

        ArrayList<String> a1 = s1.get();

        System.out.println(a1);
    }
}
