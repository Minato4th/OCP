package _7_Concurrency;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentCollections {

    public static void main(String[] args) {

    }

    public static void concurrentHashMap() {
        Map<String, Object> foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        for (String key : foodData.keySet())
            foodData.remove(key);               //ConcurrentModificationException

        Map<String, Object> foodData2 = new ConcurrentHashMap<String, Object>();
        foodData2.put("penguin", 1);
        foodData2.put("flamingo", 2);
        for (String key : foodData2.keySet())
            foodData2.remove(key);

    }

    public static void queues() {
        try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }
    }

    public static void queuesWaitingMethods() {
        try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES);
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS);
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS));
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS));
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            // Handle interruption
        }
    }

    public static void copyOnWrite() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4, 3, 52));
        for (Integer item : list) {
            System.out.print(item + " ");
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size());

    }

    public static void synchronizedCollections() {

        List<Integer> list = Collections.synchronizedList(
                new ArrayList<>(Arrays.asList(4, 3, 52)));
        synchronized (list) {
            for (int data : list)
                System.out.print(data + " ");
        }

        Map<String, Object> foodData = new HashMap<String, Object>();
        foodData.put("penguin", 1);
        foodData.put("flamingo", 2);
        Map<String, Object> synchronizedFoodData = Collections.synchronizedMap(foodData);
        for (String key : synchronizedFoodData.keySet())
            synchronizedFoodData.remove(key);                   // ConcurrentModificationException
    }


    /*
    Class Name                 Framework        Ordered? Sorted? Blocking?

    ConcurrentHashMap           ConcurrentMap       No      No      No
    ConcurrentLinkedDeque       Deque               Yes     No      No
    ConcurrentLinkedQueue       Queue               Yes     No      No
    ConcurrentSkipListMap       ConcurrentMap       Yes     Yes     No
                                SortedMap
                                NavigableMap

    ConcurrentSkipListSet       SortedSet           Yes     Yes     No
                                NavigableSet

    CopyOnWriteArrayList        List                Yes     No      No
    CopyOnWriteArraySet         Set No No No
    LinkedBlockingDeque         BlockingQueue       Yes     No      Yes
                                BlockingDeque

    LinkedBlockingQueue         BlockingQueue       Yes     No      Yes

     */

}
