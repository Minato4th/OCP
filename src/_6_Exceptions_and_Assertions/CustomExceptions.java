package _6_Exceptions_and_Assertions;

public class CustomExceptions {
}

class CannotSwimException extends Exception {

    public CannotSwimException() {
        super();
    }
    public CannotSwimException(Exception e) {
        super(e);
    }
    public CannotSwimException(String message) {
        super(message);
    }
}

class DangerInTheWater extends RuntimeException {
}

class SharkInTheWaterException extends RuntimeException {
}

class Dolphin {
    public void swim() throws CannotSwimException {
        // logic here
    }
}
