package _1_Class_Design;

public class MemberInnerClass {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
        MemberInnerClass outer = new MemberInnerClass();
        outer.callInner();

        Inner inner = outer.new Inner();
        inner.go();
    }
}