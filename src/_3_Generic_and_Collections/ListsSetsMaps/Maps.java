package _3_Generic_and_Collections.ListsSetsMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
//    void clear()                      Removes all keys and values from the map.
//    boolean isEmpty()                 Returns whether the map is empty.
//    int size()                        Returns the number of entries (key/value pairs) in the map.
//    V get(Object key)                 Returns the value mapped by key or null if none is mapped.
//    V put(K key, V value)             Adds or replaces key/value pair. Returns previous value or null.
//    V remove(Object key)              Removes and returns value mapped to key. Returns null if none.
//    boolean containsKey(Object key)   Returns whether key is in map.
//    boolean containsValue(Object)     Returns value is in map.
//    Set<K> keySet()                   Returns set of all keys.
//    Collection<V> values()            Returns Collection of all values.

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet())
            System.out.print(key + ","); // koala,giraffe,lion,
    }

    public static void useOfTreeMap() {
        Map<String, String> map = new TreeMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key : map.keySet())
            System.out.print(key + ","); // giraffe,koala,lion
    }

    public static void errors(){
        Map<String, String> map = new HashMap<>();
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
//        System.out.println(map.contains("lion")); // DOES NOT COMPILE
        System.out.println(map.containsKey("lion")); // true
        System.out.println(map.containsValue("lion")); // false
        System.out.println(map.size()); // 3
    }
}
