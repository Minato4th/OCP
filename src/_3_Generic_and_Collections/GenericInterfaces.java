package _3_Generic_and_Collections;

public class GenericInterfaces implements GenInterface<String> {
    @Override
    public void ship(String s) {

    }
}

//OR

class GenericInterfaces2<String> implements GenInterface<String>{

    @Override
    public void ship(String t) {

    }
}

interface GenInterface<T>{
    void ship(T t);
}
