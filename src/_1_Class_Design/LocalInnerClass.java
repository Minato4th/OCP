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
                System.out.println(effectivelyFinal);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public String name = "Some";

    public static void main(String[] args) {
        LocalInnerClass outer = new LocalInnerClass();
        outer.calculate();

        class LocalAnonymous {
            public String name = "Some";
            public void done(){
                System.out.println("Local");
            };
        }

        LocalAnonymous localAnonymous = new LocalAnonymous(){
            public void done(){
                System.out.println("Anonymous");
                System.out.println(name);
            }
        };

        localAnonymous.done();
    }
}

