package _1_Class_Design;

public class MemberInnerClass {
    private String greeting = "Hi";
    private final String some = "Hi";

    protected class Inner {
        public int repeat = 3;
        private final String some = "Hih";

//        private static String some;           Will not compile
//
//        private enum Go{
//            GO
//        }

        public void go() {
            for (int i = 0; i < repeat; i++)
                System.out.println(greeting);
            System.out.println(this.some);
            System.out.println(MemberInnerClass.this.some);
        }
    }

    public void callInner() {
        Inner inner = new Inner();
        inner.go();
    }

    Inner innerClass = new Inner();

    public static void main(String[] args) {
        MemberInnerClass outer = new MemberInnerClass();
        outer.callInner();

        Inner inner = outer.new Inner();
        inner.go();

        System.out.println(new MemberInnerClass().innerClass.some);
    }
}