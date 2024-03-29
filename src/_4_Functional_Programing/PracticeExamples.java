package _4_Functional_Programing;


import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PracticeExamples {

    public static void main(String[] args) {
//        Function<List<String>> ex1 = x -> x.get(0);   // DOES NOT COMPILE
//        UnaryOperator<Long> ex2 = (Long l) -> 3.14;   // DOES NOT COMIPLE
//        Predicate ex4 = String::isEmpty;              // DOES NOT COMPILE

        Predicate<List> ex1 = x -> "".equals(x.get(0));
        Consumer<Long> ex2 = (Long l) -> System.out.println(l);
        BiPredicate<String, String> ex3 = (s1, s2) -> false;
    }
}
