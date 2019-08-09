package _5_Dates_Strings_Localizations;

import java.util.Locale;

public class Localizations {

    public static void main(String[] args) {


    }


    public static void locale() {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
//        de_DE     language_locale
//        US        // can have a language without a country, but not the reverse
//        enUS      // missing underscore
//        US_en     // the country and language are reversed
//        EN        // language must be lowercase

        System.out.println(Locale.GERMAN); // de
        System.out.println(Locale.GERMANY); // de_DE

        System.out.println(new Locale("fr")); // fr
        System.out.println(new Locale("hi", "IN")); // hi_IN

        Locale l1 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();

        Locale l2 = new Locale.Builder()
                .setRegion("US")
                .setLanguage("en")
                .build();

        System.out.println(Locale.getDefault()); // en_US
        locale = new Locale("fr");
        Locale.setDefault(locale); // change the default
        System.out.println(Locale.getDefault()); // fr
    }

//    public static void creatingDate() {
//
//    }
//
//    public static void creatingDate() {
//
//    }
//
//    public static void creatingDate() {
//
//    }
//
//    public static void creatingDate() {
//
//    }
}
