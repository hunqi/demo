package v2ch07;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

    public static void main(String[] args) {
        Locale loc = new Locale("de", "DE");
        NumberFormat currentFmt = NumberFormat.getCurrencyInstance(loc);
        double amt = 123456.78;
        String result = currentFmt.format(amt);
        System.out.println("result=" + result);

        Locale defaultLoc = Locale.getDefault();
        NumberFormat defaultFmt = NumberFormat.getCurrencyInstance(defaultLoc);
        System.out.println("result=" + defaultFmt.format(amt));

        Locale cnLoc = new Locale("zh", "CN");
        NumberFormat cnFmt = NumberFormat.getCurrencyInstance(cnLoc);
        System.out.println("result=" + cnFmt.format(amt));

        for (Locale l : NumberFormat.getAvailableLocales())
            System.out.println(l.getDisplayLanguage() + ", " + l.getDisplayCountry());
    }

}
