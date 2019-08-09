package _3_Generic_and_Collections;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMethods<T> {

    T t;

    public GenericMethods(T t) {
        this.t = t;
    }

    public static <T> GenericMethods<T> ship(T t){
        return new GenericMethods<>(t);
    }

   public static <T> void sink(T t) { }
   public static <T> T identity(T t) { return t; }
   //public static T noGood(T t) { return t; } // DOES NOT COMPILE

    public static void errorLegacy(List<Integer> right){
        for (Integer i: right){ //throw ClassCastException
            System.out.println(i);
        }
    }

    public static void errorLegacyTwo(List right){
        right.add(new Integer(5)); //throw ClassCastException
    }

    public static void main(String[] args) {
        GenericMethods<String> genericMethods = ship("Hello");
        System.out.println(genericMethods.t);


        List errorlist = new ArrayList();
        errorlist.add("asdsa");
        errorLegacy(errorlist);

        List<String> good = Arrays.asList("some");
        errorLegacyTwo(good);
    }
}
