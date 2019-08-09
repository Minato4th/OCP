package _7_Concurrency;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Callables {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<Integer> result = service.submit(() -> 30+11);       //Callable interface is used
            System.out.println(result.get());
        } finally {
            if(service != null) service.shutdown();
        }
    }

    //Callable vs Supplier
    public static void useCallable(Callable<Integer> expression) {}
    public static void useSupplier(Supplier<Integer> expression) {}
    public static void use(Supplier<Integer> expression) {}
    public static void use(Callable<Integer> expression) {}

    public static void CallableVsSupplier(String[] args) {
        useCallable(() -> {throw new IOException();}); // COMPILES
//        useSupplier(() -> {throw new IOException();}); // DOES NOT COMPILE
//        use(() -> {throw new IOException();}); // DOES NOT COMPILE
    }


//    public static void noSuppressed() {
//
//
//    }

}
