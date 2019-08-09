package _3_Generic_and_Collections;

import java.util.*;

public class GenericClasses<T> {

    private T contents;

    public T emptyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }

    public static void main(String[] args) {
        GenericClasses<String> genericClasses = new GenericClasses<>();
        genericClasses.packCrate("Hello");
        System.out.println(genericClasses.emptyCrate());

    }
}

/* Type parameters naming

    E for an element
    K for a map key
    V for a map value
    N for a number
    T for a generic data type
    S, U, V, and so forth for multiple generic types

*/