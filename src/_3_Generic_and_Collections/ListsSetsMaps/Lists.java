package _3_Generic_and_Collections.ListsSetsMaps;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    //LinkedList is special because it implements both List and Queue.
    //The main benefits of a LinkedList are that you can access, add, and remove from the beginning and end of the list in constant time

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("SD"); // [SD]
        list.add(0, "NY"); // [NY,SD]
        list.set(1, "FL"); // [NY,FL]
        list.remove("NY"); // [FL]
        list.remove(0); // []

        list.add("OH"); // [OH]
        list.add("CO"); // [OH,CO]
        list.add("NJ"); // [OH,CO,NJ]
        String state = list.get(0); // OH
        int index = list.indexOf("NJ"); // 2
    }
}
