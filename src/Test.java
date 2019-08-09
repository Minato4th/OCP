import java.util.Locale;

public class Test {
    private String one;
    private String two;

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public static void main(String[] args) {
        final Test test = new Test();
        test.setOne("asda");
        test.setTwo("asdsa");

        System.out.println(test.getOne());
        System.out.println(test.getTwo());

        test.setOne("asda");
        String st = String.format("%s%2$06d", "M20190712031747IRTP04362518101000001", 1L);

        System.out.println(st);
        System.out.println(Locale.getDefault());


        final DaysOff input = DaysOff.Thanksgiving;
        switch (input) {
            default:
            case ValentinesDay:
                System.out.print("1");
            case PresidentsDay:
                System.out.print("2");
        }

    }

    enum DaysOff {
        Thanksgiving, PresidentsDay, ValentinesDay
    }

}
