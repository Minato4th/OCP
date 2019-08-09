package _1_Class_Design;

public class StaticNestedClass {

    static class StaticNested{
        private static String some;

        private enum Go{
            GO
        }

        public static void soSome(){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        StaticNested staticNested = new StaticNested();
        StaticNested.soSome();

        StaticNestedClass nestedClass = new StaticNestedClass();
//        StaticNested nested = nestedClass.new StaticNested(); only member/inner classes can be


    }
}
