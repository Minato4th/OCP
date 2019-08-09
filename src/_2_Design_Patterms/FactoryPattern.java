package _2_Design_Patterms;


public class FactoryPattern {

    public static Factory getConsumed(final int consumed) {
        switch (consumed) {
            case 10:
                return new Factory1(10);
            case 20:
                return new Factory2(20);
            default:
                throw new UnsupportedOperationException("Wrong element");
        }

    }
}

class Wheels {
    public static void main(String[] args) {
        final Factory factory1 = FactoryPattern.getConsumed(10);
        final Factory factory2 = FactoryPattern.getConsumed(20);

        factory1.consumed();
        factory2.consumed();
    }
}

abstract class Factory {
    private int quantity;

    public Factory(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract void consumed();
}

class Factory1 extends Factory {

    public Factory1(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Factory 1 - " + getQuantity());
    }
}

class Factory2 extends Factory {

    public Factory2(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Factory 2 - " + getQuantity());
    }
}

