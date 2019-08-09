package _7_Concurrency;

import java.util.concurrent.*;

public class ExecutorServices {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Runtime.getRuntime().availableProcessors();
        scheduling();
    }

    public static void singleThreadExecutor() {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            service.execute(() -> System.out.println("Printing zoo inventory"));
            service.execute(() -> {
                        for (int i = 0; i < 3; i++)
                            System.out.println("Printing record: " + i);
                    }
            );
            service.execute(() -> System.out.println("Printing zoo inventory"));
            System.out.println("end");
        } finally {
            if (service != null) {
                System.out.println(service.isTerminated());         // isTerminated
                System.out.println(service.isShutdown());           // isShutdown
                service.shutdown();                                 // shutdown
            }
        }
    }

    public static void newFixedThreadPool() {

        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(10);
            System.out.println("begin");
            service.execute(() -> {
                        for (int i = 0; i < 3; i++)
                            System.out.println("Printing record: " + i);
                    }
            );
            System.out.println("end");
        } finally {
            if (service != null) {
                System.out.println(service.isTerminated());         // isTerminated
                System.out.println(service.isShutdown());           // isShutdown
                service.shutdown();                                 // shutdown
            }
        }
    }

    public static void newSingleThreadScheduledExecutor() {

        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();
            System.out.println("begin");
            service.scheduleAtFixedRate(() -> {
                for (int i = 0; i < 3000; i++)
                    System.out.println("Printing record: " + i);
            },
                    3, 1, TimeUnit.MILLISECONDS);

            System.out.println("end");
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public static void newScheduledThreadPool() {

        ScheduledExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            System.out.println("begin");
            service.scheduleAtFixedRate(() -> {
                        for (int i = 0; i < 3000; i++)
                            System.out.println("Printing record: " + i);
                    },
                    3, 1, TimeUnit.MILLISECONDS);

            System.out.println("end");
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static int counter = 0;

    public static void submitExample() throws ExecutionException, InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {               // submit return something to monitor
                for (int i = 0; i < 500; i++) ExecutorServices.counter++;
            });
            System.out.println(result.isCancelled());                           //false
            System.out.println(result.isDone());                                //false
            System.out.println(result.get(1, TimeUnit.MILLISECONDS));  // not done
            result.get(10, TimeUnit.SECONDS);                         // retries result
            System.out.println("Reached!");
        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null) service.shutdown();
        }
    }

    public static void await() throws InterruptedException {

        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 5000; i++) ExecutorServices.counter++;
            });

        } finally {
            if (service != null) service.shutdown();
        }

        if (service != null) {
            service.awaitTermination(1, TimeUnit.MILLISECONDS);
            // Check whether all tasks are finished
            if (service.isTerminated())
                System.out.println("All tasks finished");
            else
                System.out.println("At least one task is still running");
        }

    }


    public static void scheduling() throws InterruptedException, ExecutionException {

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable task1 = () -> System.out.println("Hello Zoo");
        Callable<String> task2 = () -> "Monkey";

        Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS);
        Future<?> result2 = service.schedule(task2, 1, TimeUnit.SECONDS);
        Future<?> result3 = service.scheduleAtFixedRate(task1, 5, 1, TimeUnit.MINUTES);
        Future<?> result4 = service.scheduleWithFixedDelay(task1, 0, 2, TimeUnit.MINUTES); // scheduleAtFixedDelay in the book
    }

}


