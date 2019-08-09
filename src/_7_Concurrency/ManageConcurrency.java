package _7_Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManageConcurrency {

    public static void main(String[] args) {

    }

    public static void standartPoolExecution() {

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            ManageConcurrency manager = new ManageConcurrency();
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if (service != null) service.shutdown();             //unordered result
        }
    }

    public static void cyclicBarrier() {

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(4);
            ManageConcurrency manager = new ManageConcurrency();
            CyclicBarrier c1 = new CyclicBarrier(4);
            CyclicBarrier c2 = new CyclicBarrier(4,
                    () -> System.out.println("*** Pen Cleaned!"));
            for (int i = 0; i < 4; i++)
                service.submit(() -> manager.performTask(c1, c2));  //ordered result
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public void performTask() {
        removeAnimals();
        cleanPen();
        addAnimals();
    }

    public void performTask(CyclicBarrier c1, CyclicBarrier c2) {
        try {
            removeAnimals();
            c1.await();
            cleanPen();
            c2.await();
            addAnimals();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }
    }

    private void removeAnimals() {
        System.out.println("Removing animals");
    }

    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }

    private void addAnimals() {
        System.out.println("Adding animals");
    }

//    public static void noSuppressed() {
//
//
//    }
//    public static void noSuppressed() {
//
//
//    }
//    public static void noSuppressed() {
//
//
//    }

}
