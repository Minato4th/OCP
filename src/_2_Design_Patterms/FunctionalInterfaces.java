package _2_Design_Patterms;

@FunctionalInterface
public interface FunctionalInterfaces {
    void doSomething();
}

abstract interface Hello {

}

class Fun implements FunctionalInterfaces {

    @Override
    public void doSomething() {
        System.out.println("Something");
    }
}


