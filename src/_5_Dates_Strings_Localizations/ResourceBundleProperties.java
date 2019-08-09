package _5_Dates_Strings_Localizations;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class ResourceBundleProperties {

    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);
    }

    public static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("_5_Dates_Strings_Localizations/Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }

    public static void properties() {
        Locale us = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("_5_Dates_Strings_Localizations/Zoo", us);
        Set<String> keys = rb.keySet();
        keys.stream().map(k -> k + " " + rb.getString(k))
                .forEach(System.out::println);

        Properties props = new Properties();
        rb.keySet().stream()
                .forEach(k -> props.put(k, rb.getString(k)));

        Properties props2 = new Properties();
        rb.keySet().stream()
                .forEach(k -> props2.put(k, rb.getString(k)));

        System.out.println(props2.getProperty("notReallyAProperty"));                           //null if not found
        System.out.println(props2.getProperty("notReallyAProperty", "123"));      // 123 if not found

    }
}

