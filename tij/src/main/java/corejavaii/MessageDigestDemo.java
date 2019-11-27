package corejavaii;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This demo shows how to generate message digest for data block
 * message digest algorithms contain: MD5, SHA-1, SHA-256, SHA-384, SHA-512
 */
public class MessageDigestDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String msg = "hello, world";
        MessageDigest algm = MessageDigest.getInstance("SHA-256");
        byte[] hash = algm.digest(msg.getBytes());

        System.out.println("length of sha256: " + hash.length);
        System.out.printf("%-20s: %s\n", "toHex(hash)", toHex(hash));

//        hash = sha256.digest("hello, java".getBytes());
        System.out.printf("%-20s: %s\n", "encode(byte[] bytes)", new String(encode(hash)));
    }

    public static String toHex(byte[] hash) {
        String d = "";
        for (int i = 0; i < hash.length; i++) {
            int v = hash[i] & 0xFF;
            if (v < 16) d += "0";   // prepend "0" to left if v less than 16
            d += Integer.toString(v, 16).toUpperCase() + "";
        }
        return d;
    }

    private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] encode(byte[] bytes) {
        final int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];

        int j = 0;
        for (int i = 0; i < nBytes; i++) {
            // Char for top 4 bits
            result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];
            // Bottom 4
            result[j++] = HEX[(0x0F & bytes[i])];
        }

        return result;
    }

}
