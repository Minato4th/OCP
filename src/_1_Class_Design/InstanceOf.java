package _1_Class_Design;

public class InstanceOf {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a instanceof C);
    }

}

interface C {}
class A{}
class B implements C{}
