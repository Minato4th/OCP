package _3_Generic_and_Collections.ListsSetsMaps;

import java.util.HashSet;
import java.util.Set;

public class Sets {

    //TreeSet stores its elements in a sorted tree structure

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        boolean b1 = set.add(66); // true
        boolean b2 = set.add(10); // true
        boolean b3 = set.add(66); // false
        boolean b4 = set.add(8); // true
        for (Integer integer: set) System.out.print(integer + ","); // 66,8,10,

        Set<Integer> sets = new HashSet<>();
        boolean a1 = sets.add(66); // true
        boolean a2 = sets.add(10); // true
        boolean a3 = sets.add(66); // false
        boolean a4 = sets.add(8); // true
        for (Integer integer: set) System.out.print(integer + ","); // 8,10,66
    }
}
