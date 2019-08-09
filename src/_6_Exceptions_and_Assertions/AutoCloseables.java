package _6_Exceptions_and_Assertions;

public class AutoCloseables {

    public static void main(String[] args) {
//        try (String t = new String()) { // DOES NOT COMPILE
//            System.out.println(t);
//        }

        try (TurkeyCage t = new TurkeyCage()) {
            System.out.println("put turkeys in");
        }

//        try (StuckTurkeyCage t = new StuckTurkeyCage()) { // DOES NOT COMPILE - unhandled exception
//            System.out.println("put turkeys in");
//        }
    }

        public static void oldStyle() {

        }
}

class TurkeyCage implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Close gate");
    }
}


//Bad examples - are not Idempotent
class StuckTurkeyCage implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}

class ExampleOne implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}
class ExampleTwo implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}
class ExampleThree implements AutoCloseable {
    static int COUNT = 0;
    public void close() {
        COUNT++;
    }
}
