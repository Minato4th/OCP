package _3_Generic_and_Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Difference                                           Comparable  Comparator
//Package name                                          java.lang   java.util
//Interface must be implemented by class comparing?     Yes         No
//Method name in interface                              compareTo   compare
//Number of parameters                                  1           2
//Common to declare using a lambda                      No          Yes
public class ComparatorExample {

    private int number;

    private String word;

    public ComparatorExample(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public int getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }

    public static void main(String[] args) {

    }

    public static void usingInnerClass(){
        Comparator<ComparatorExample> byWeight = new Comparator<ComparatorExample>() {
            public int compare(ComparatorExample d1, ComparatorExample d2) {
                return d1.getNumber()-d2.getNumber();
            }
        };

        List<ComparatorExample> ex = Arrays.asList(new ComparatorExample(25, "Hello")
                , new ComparatorExample(35, "sorry"));

        Collections.sort(ex, byWeight);

        ex.forEach(System.out::println);
    }

    public static void usingLambda(){
        Comparator<ComparatorExample> byWeight = (d1,d2) -> d1.getNumber() + d2.getNumber();

        List<ComparatorExample> ex = Arrays.asList(new ComparatorExample(25, "Hello")
                , new ComparatorExample(35, "sorry"));

        Collections.sort(ex, (d1,d2) -> d1.getNumber() + d2.getNumber());

        ex.forEach(System.out::println);
    }
}


