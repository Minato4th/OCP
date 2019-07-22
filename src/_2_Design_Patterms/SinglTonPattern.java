package _2_Design_Patterms;

public class SinglTonPattern {

    private int age = 0;
    private SinglTonPattern(){

    };

    private static final SinglTonPattern entity = new SinglTonPattern();

    public static SinglTonPattern getEntity(){
        return entity;
    }

    public synchronized void addAge(final int age){
        this.age = this.age + age;
    }

    public synchronized int geAge(){
        return this.age;
    }
}
