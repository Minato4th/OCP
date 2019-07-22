package _2_Design_Patterms;

public class FunctionalSimpleExample {
    public static void print(Bird bird, Function function){
        System.out.println(function.canFly(bird));
    }

    public static void main(String[] args) {
        print(new Bird("Some", true), a -> a.isCanFly());
        print(new Bird("Some", false), Bird::isCanFly);
    }
}

interface Function {
    boolean canFly(Bird bird);
}

class Bird {
    private String name;
    private boolean canFly;

    public Bird(String name, boolean canFly) {
        this.name = name;
        this.canFly = canFly;
    }

    public String getName() {
        return name;
    }

    public boolean isCanFly() {
        return canFly;
    }
}