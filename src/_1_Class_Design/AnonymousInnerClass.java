package _1_Class_Design;

public class AnonymousInnerClass {

    interface Edible {
        void eat();
    }

    abstract class SaleTodayOnly {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleTodayOnly sale = new SaleTodayOnly() {
            int dollarsOff() {
                return 3;
            }
        };
        return basePrice - sale.dollarsOff();

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Run");
            }
        };

        Edible edible = new Edible() {
//            @Override
//            void eat() {              doesn't compile because not public as in interface
//
//            }

            @Override
            public void eat() {

            }
        };
    }
}
