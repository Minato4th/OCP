package _7_Concurrency;

public class PollingWithSleep {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        withSleep();
        withoutSleep();
    }

    public static void withoutSleep() {
        new Thread(() -> {
            for(int i=0; i<500; i++) PollingWithSleep.counter++;
        }).start();
        while(PollingWithSleep.counter<100) {
            System.out.println("Not reached yet");
        }
        System.out.println("Reached!");
    }

    public static void withSleep() throws InterruptedException {
        new Thread(() -> {
            for(int i=0; i<500; i++) PollingWithSleep.counter++;
        }).start();
        while(PollingWithSleep.counter<100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 SECOND
        }
        System.out.println("Reached!");
    }
}

