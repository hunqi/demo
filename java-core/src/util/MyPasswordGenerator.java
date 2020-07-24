package util;

import java.security.SecureRandom;

public class MyPasswordGenerator {

    static final byte[] NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static final char[] CAP_LETTERS =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                    'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                    'Y', 'Z'};
    static final char[] LOWERCASE = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] PUNCTUATION_MARK = {'!', '@', '#', '$', '&', '*', '(', ')', '-', '+'};

    static final char[] SRC_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '!', '@', '#', '$', '&', '*', '-', '+'};

    String generate(int digit) {
        String result = "";

        SecureRandom random = new SecureRandom();
        random.setSeed(System.currentTimeMillis());

        int i = 0;
        for (int j = 0; j < digit; j++) {
            i = random.nextInt(70);
            System.out.println("i=" + i);
            result += SRC_CHARS[i];
        }

        return result;
    }

    public static void main(String[] args) {
        MyPasswordGenerator generator = new MyPasswordGenerator();
        System.out.println(generator.generate(16));
    }

}
