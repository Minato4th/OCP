package _4_Functional_Programing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TrickyExamples {

    public static void main(String[] args) {
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream();
        cats.add("KC");
        System.out.println(stream.count()); // 3
    }

    private static void threeDigit(Optional<Integer> optional) {
        if (optional.isPresent()) { // outer if
            Integer num = optional.get();
            String string = "" + num;
            if (string.length() == 3) // inner if
                System.out.println(string);
        }
        optional.map(n -> "" + n) // part 1
                .filter(s -> s.length() == 3) // part 2
                .ifPresent(System.out::println); // part 3
    }
}
