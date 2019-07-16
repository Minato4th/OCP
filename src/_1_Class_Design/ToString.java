package _1_Class_Design;

import java.util.Arrays;
import java.util.function.Supplier;

public class ToString {

    public static void main(String[] args) {
//        ArrayList<String> list = (ArrayList<String>);
        System.out.println(Arrays.asList("Hello", "Something").toString());
        int x = 5;

        Supplier<Boolean> lambda = () -> (x%2) == 0;
        System.out.println(lambda.get());

    }
}
