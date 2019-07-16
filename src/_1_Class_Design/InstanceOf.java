package _1_Class_Design;

import java.util.Objects;

public class InstanceOf {

    private String a = "sdf";

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstanceOf that = (InstanceOf) o;
        return Objects.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a instanceof C);
    }

}

interface C {}
class A{}
class B implements C{}
