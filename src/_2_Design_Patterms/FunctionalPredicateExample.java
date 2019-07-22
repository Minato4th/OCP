package _2_Design_Patterms;

import java.util.function.Predicate;

public class FunctionalPredicateExample {

    public static void print(Birds birds, Predicate<Birds> predicate){
        System.out.println(predicate.test(birds));
    }

    public static void main(String[] args) {
        print(new Birds("Some", true), a -> a.isCanFly());
        print(new Birds("Some", false), Birds::isCanFly);
//        print(new Birds("Some", true), a -> a.getName()); won't work, wrong interface return type
    }
}

class Birds {
    private String name;
    private boolean canFly;

    public Birds(String name, boolean canFly) {
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