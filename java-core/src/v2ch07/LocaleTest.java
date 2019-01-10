package v2ch07;

import java.util.Locale;

public class LocaleTest {

    public static void main(String[] args) {

        Locale usEnglish = Locale.forLanguageTag("en-US");
        System.out.println(usEnglish.getDisplayCountry());

        Locale cnChinese = Locale.forLanguageTag("zh-CN");
        System.out.println(cnChinese.getDisplayCountry());

        Locale locale = Locale.getDefault();
        System.out.println("locale: " + locale.getDisplayCountry());

        for (Locale l : Locale.getAvailableLocales())
            System.out.println(l.getDisplayLanguage() + ", " + l.getDisplayCountry());
    }

}
