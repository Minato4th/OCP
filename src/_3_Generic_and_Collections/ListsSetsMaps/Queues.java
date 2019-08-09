package _3_Generic_and_Collections.ListsSetsMaps;

import java.util.ArrayDeque;
import java.util.Queue;

public class Queues {

    //When talking about LIFO (stack), people say push/poll/peek.
    //When talking about FIFO (single-ended queue), people say offer/poll/peek.

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10)); // true
        System.out.println(queue.offer(4)); // true
        System.out.println(queue.peek()); // 10
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 4
        System.out.println(queue.peek()); // null

        //System.out.println(queue.element()); throw NoSuchElementException
        //System.out.println(queue.pop()); throw NoSuchElementException

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek()); // 4
        System.out.println(stack.poll()); // 4
        System.out.println(stack.poll()); // 10
        System.out.println(stack.peek()); // null
    }
}
