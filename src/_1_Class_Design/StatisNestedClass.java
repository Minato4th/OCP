package _1_Class_Design;

public class StatisNestedClass {

    static class StaticNested{
        public static void soSome(){
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) {
        StaticNested staticNested = new StaticNested();
        StaticNested.soSome();


    }
}
