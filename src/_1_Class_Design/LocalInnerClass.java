package _1_Class_Design;

public class LocalInnerClass {
    private int length = 5;

    public void calculate() {
        final int width = 20;
        int effectivelyFinal = 25;
        int notEffectivelyFinal = 5;
        notEffectivelyFinal++;
        class Inner {
            public void multiply() {
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        LocalInnerClass outer = new LocalInnerClass();
        outer.calculate();
    }
}

