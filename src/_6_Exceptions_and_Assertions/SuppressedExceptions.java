package _6_Exceptions_and_Assertions;

public class SuppressedExceptions {

    public static void main(String[] args) {

        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());  // will throw Cage door does not close
        }


        suppressedException();
        getSuppressed();
    }

    public static void getSuppressed() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());  // caught: turkeys ran off
            // Cage door does not close
        }
    }

    public static void suppressedException() {
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new RuntimeException("turkeys ran off");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            /*
            Exception in thread "main" java.lang.RuntimeException: turkeys ran off
               atJammedTurkeyCage.main(JammedTurkeyCage.java:20)
               Suppressed: java.lang.IllegalStateException: Cage door does not close
            */
        }
    }

    public static void suppressedExample() {

        try (JammedTurkeyCage t1 = new JammedTurkeyCage();
             JammedTurkeyCage t2 = new JammedTurkeyCage()) {
            System.out.println("turkeys entered cages");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage());  //turkeys entered cages
                                                    // caught: Cage door does not close
                                                    // Cage door does not close
        }

    }

    public static void noSuppressed() {

        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            throw new IllegalStateException("turkeys ran off");
        } finally {
            throw new RuntimeException("and we couldn't find them");
        }
    }

}

class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}
