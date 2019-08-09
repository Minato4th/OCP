package _8_IO;

import java.io.Serializable;

public class Serializables implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private char type;
    private transient String surname;
    private transient int lo = 10;

    public Serializables(String name, int age, char type, String surname, int lo) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.surname = surname;
        this.lo = lo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

    public String toString() {
        return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
    }


}
