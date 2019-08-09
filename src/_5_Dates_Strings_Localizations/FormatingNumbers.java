package _5_Dates_Strings_Localizations;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormatingNumbers {

    public static void main(String[] args) {
        int attendeesPerYear = 3_200_000;
        int attendeesPerMonth = attendeesPerYear / 12;

        NumberFormat us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(attendeesPerMonth));       //266,666

        NumberFormat g = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println(g.format(attendeesPerMonth));        //266.666

        NumberFormat ca = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(ca.format(attendeesPerMonth));       //266 666

        double price = 48;
        us = NumberFormat.getCurrencyInstance();
        System.out.println(us.format(price));
    }

    public static void example() throws ParseException {
        NumberFormat en = NumberFormat.getInstance(Locale.US);
        NumberFormat fr = NumberFormat.getInstance(Locale.FRANCE);

        String s = "40.45";
        System.out.println(en.parse(s)); // 40.45
        System.out.println(fr.parse(s)); // 40
    }

    public static void example2() throws ParseException {
        NumberFormat nf = NumberFormat.getInstance();
        String one = "456abc";
        String two = "-2.5165x10";
        String three = "x85.3";
        System.out.println(nf.parse(one)); // 456
        System.out.println(nf.parse(two)); // -2.5165
        System.out.println(nf.parse(three));// throws ParseException

    }

    public static void example3() throws ParseException {
        String amt = "$92,807.99";
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double value = (Double) cf.parse(amt);
        System.out.println(value); // 92807.99
    }


}
