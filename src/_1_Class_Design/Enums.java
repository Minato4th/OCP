package _1_Class_Design;

public class Enums {
    public static void main(String[] args) {
        Some3.TWO.hello();
    }
}

enum Some {
    ONE, TWO
}

enum Some2 {
    ONE("Hello"),
    TWO("no");

    String value;

    Some2(String value) {
        this.value = value;
    }

    void printSome() {
        System.out.println(value);
    }

}

enum Some3 {
    ONE {
        public void hello() {
            System.out.println("Hello");
        }
    },
    TWO {
        public void hello() {
            System.out.println("Hello2");
        }
    };

    abstract void hello();
}

enum Some4 {
    ONE(1) {
        public void hello() {
            System.out.println("Hello");
        }

        @Override
        public void protect(){};
    },
    TWO(2) {
        public void protect(){};

        public void hello() {
            System.out.println("Hello2");
        }

        @Override
        public void done() {
            System.out.println("Hello2");
        }
    };

    private final int number;

    Some4(int number) {
        this.number = number;
    }

    abstract void hello();

    protected abstract void protect();

    void done(){};
}
