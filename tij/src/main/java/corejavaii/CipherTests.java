package corejavaii;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class CipherTests {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {

        String alg = "AES";
        Key key = generateKey(alg);

        Cipher cipher = Cipher.getInstance(alg);
        cipher.init(Cipher.ENCRYPT_MODE, key);

        String data = "hello, world";
        System.out.printf("source data: %s\n", data);
        byte[] output = cipher.doFinal(data.getBytes("UTF-8"));
        System.out.println(toHex(output));

        cipher.init(Cipher.DECRYPT_MODE, key);
        output = cipher.doFinal(output);
        System.out.printf("decrypted: %s\n", new String(output));
    }

    static String toHex(byte[] data){
        String result = "";

        for (int i=0; i<data.length; i++){
            int lower = data[i] & 0xFF;
            if (lower < 16) result += "0" + Integer.toHexString(data[i] & 0xFF).toUpperCase() + " ";
            else
                result += Integer.toHexString(data[i] & 0xFF).toUpperCase() + " ";
        }

        return result;
    }

    static Key generateKey(String alg) throws NoSuchAlgorithmException {
        return keygen(alg).generateKey();
    }

    static KeyGenerator keygen(String alg) throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance(alg);
        generator.init(new SecureRandom());
        return generator;
    }

}
