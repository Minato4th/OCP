package _5_Dates_Strings_Localizations;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleClass extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"tax", "Hello!"}};
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("_5_Dates_Strings_Localizations.ResourceBundleClass", Locale.US);
        System.out.println(rb.getObject("tax"));
    }
}
