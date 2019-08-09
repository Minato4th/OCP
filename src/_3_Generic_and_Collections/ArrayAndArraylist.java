package _3_Generic_and_Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAndArraylist {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();      // empty list
        list.add("Fluffy");                         // [Fluffy]
        list.add("Webby");                          // [Fluffy, Webby]

        String[] array = new String[list.size()];   // empty array

        array[0] = list.get(1);                     // [Webby]
        array[1] = list.get(0);                     // [Webby, Fluffy]
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "-");


    }

    public static void exampleListToArray(){
        String[] array = { "gerbil", "mouse" };         // [gerbil, mouse]
        List<String> list = Arrays.asList(array);       // returns fixed size list
        list.set(1, "test");                            // [gerbil, test]
        array[0] = "new";                               // [new, test]
        String[] array2 = (String[]) list.toArray();    // [new, test]
        list.remove(1);                            // throws UnsupportedOperationException
    }

    public static void sortingAndSearching(){
        int[] numbers = {6,9,1,8};
        Arrays.sort(numbers);                                       // [1,6,8,9]
        System.out.println(Arrays.binarySearch(numbers, 6));    // 1
        System.out.println(Arrays.binarySearch(numbers, 3));    // -2

        List<Integer> list = Arrays.asList(9,7,5,3);
        Collections.sort(list);                                      // [3, 5, 7, 9]
        System.out.println(Collections.binarySearch(list, 3));   // 0
        System.out.println(Collections.binarySearch(list, 2));   // -1
    }
}
