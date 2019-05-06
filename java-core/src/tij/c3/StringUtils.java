package tij.c3;

public class StringUtils {

    /**
     * @param s1
     * @param s2
     * @return 0 represents equivalence, 1 represents s1 is before s2, -1 represents s1 after s2 according to alphabet
     */
    public static int compare(String s1, String s2) {
        if (null == s1 && null == s2)
            return 0;
        if (null == s1)
            return -1;
        if (null == s2)
            return 1;

        s1 = s1.trim();
        s2 = s2.trim();

        if (s1.length() == 0 && s2.length() == 0)
            return 0;
        if (s1.length() == 0)
            return -1;
        if (s2.length() == 0)
            return 1;

        if (isNoTextCharacter(s1) && isNoTextCharacter(s2))
            return 0;
        if (isNoTextCharacter(s1))
            return -1;
        if (isNoTextCharacter(s2))
            return 1;

        int len1 = s1.length(), len2 = s2.length(), len = len1;

        if (len1 > len2)
            len = len2;

        for (int i = 0; i < len; i++) {
            if (isEmptyChar(s1.charAt(i)) && isEmptyChar(s2.charAt(i)))
                continue;
            if (isEmptyChar(s1.charAt(i)))
                return -1;
            if (isEmptyChar(s2.charAt(i)))
                return 1;

            if (s1.charAt(i) < s2.charAt(i))
                return 1;
            if (s1.charAt(i) > s2.charAt(i))
                return -1;
        }

        if (len1 < len2)
            return 1;
        if (len1 > len2)
            return -1;

        return 0;
    }

    private static boolean isNoTextCharacter(String s) {
        if (null == s || s.length() == 0)
            return true;

        for (int i = 0, len = s.length(); i < len; i++) {
            if (s.charAt(i) != 32)
                return false;
        }

        return true;
    }

    // integer value of empty char (' ') is 32
    private static boolean isEmptyChar(char c) {
        return c == 32;
    }

    public static void main(String[] args) {
//        char c = ' ';
//        int cval = c;
//        System.out.println("cval=" + cval);

//        System.out.println(isEmptyChar(' '));
//        System.out.println(isEmptyChar('0'));
//
//        System.out.println(isNoTextCharacter("          "));
//        System.out.println(isNoTextCharacter("  0   "));

        String s1 = "";
        String s2 = "";
//        System.out.println(compare(s1, s2));
//
//        s1 = "a";
//        s2 = "a";
//        System.out.println(compare(s1, s2));

//        s1 = "a";
//        s2 = "A";
//        System.out.println(compare(s1, s2));
//
//        s1 = "abcd";
//        s2 = "abcdefg";
//        System.out.println(compare(s1, s2));
//
//        s1 = "abdd";
//        s2 = "abcd";
//        System.out.println(compare(s1, s2));

        s1 = "abcd  d";
        s2 = "abcd  c";
        System.out.println(compare(s1, s2));
    }

}
