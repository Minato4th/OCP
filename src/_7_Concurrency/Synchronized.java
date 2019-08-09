package _7_Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.*;

public class Synchronized {

    private int sheepCount = 0;
    private AtomicInteger sheepCountAtomic = new AtomicInteger(0);

    public static void main(String[] args) {
        atomics();
    }

    public static void unsynchronized() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            Synchronized manager = new Synchronized();
            for(int i=0; i<10; i++)
                service.submit(() -> manager.incrementAndReport());
        } finally {
            if(service != null) service.shutdown();
        }
    }

    public static void withSynchronizedBlock() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            Synchronized manager = new Synchronized();
            for(int i=0; i<10; i++)
                synchronized(manager) {
                    service.submit(() -> manager.incrementAndReport());
                }
        } finally {
            if(service != null) service.shutdown();
        }
    }

    private void incrementAndReport() {
        System.out.print((++sheepCount)+" ");
    }

    private void incrementAndReportSynchronized() {
        synchronized(this) {
            System.out.print((++sheepCount)+" ");
        }
    }

    public static void printDaysWorkStatic() {
        synchronized(Synchronized.class) {
            System.out.print("Finished work");
        }
    }
    public static synchronized void printDaysWorkStaticSynchMethod() {
        System.out.print("Finished work");
    }

    private synchronized void incrementAndReportSynchronizedMethod() {
        System.out.print((++sheepCount)+" ");
    }

    public static void synchronizedAtomic() {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            Synchronized manager = new Synchronized();
            for(int i=0; i<10; i++)
                service.submit(() -> manager.incrementAndReportAtomic());
        } finally {
            if(service != null) service.shutdown();
        }
    }

    private void incrementAndReportAtomic() {
        System.out.print(sheepCountAtomic.incrementAndGet()+" ");
    }

    public static void atomics() {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicInteger atomicInteger = new AtomicInteger(5);
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1,2,3});
        AtomicLong atomicLong = new AtomicLong(1L);
        AtomicLongArray atomicLongArray = new AtomicLongArray(new long[]{1L,2L,3L});
        AtomicReference<String> atomicReference = new AtomicReference<>("Hello");
        AtomicReferenceArray<Integer> atomicReferenceArray = new AtomicReferenceArray<>(new Integer[]{1,2,3,4});

        System.out.println(atomicInteger.get());                 //5
        atomicInteger.set(1);
        System.out.println(atomicInteger.incrementAndGet());      //2
        System.out.println(atomicInteger.getAndIncrement());      //2
        System.out.println(atomicInteger.decrementAndGet());      //2
        System.out.println(atomicInteger.getAndDecrement());      //2

    }

}
