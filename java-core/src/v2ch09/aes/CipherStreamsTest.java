package v2ch09.aes;

import javax.crypto.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Test CipherOutputStream, CipherInputStream
 */
public class CipherStreamsTest {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, ClassNotFoundException, InvalidKeyException {
        if (args.length < 3) {
            System.out.println("Warning!!! Running parameters missing");
            return;
        }

        String aesAlg = "AES";

        String keyFile = "cssk";
        if (args[2] != null) {
            keyFile = args[2];
        }

        Cipher cipher = Cipher.getInstance(aesAlg);
        Key key;
        if (Files.exists(Paths.get(keyFile))) {
            try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(keyFile))) {
                key = (Key) keyIn.readObject();
            }
        } else {
            key = genKey("AES", keyFile);
        }

        if (args[0].equals("-encrypt")) {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            try (CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(args[1]), cipher)) {
                byte[] data = "hello world, hello all my feeling".getBytes();
                cos.write(data);
            }
        } else {
            cipher.init(Cipher.DECRYPT_MODE, key);
            System.out.println("File path: " + args[1]);
            try (CipherInputStream cis = new CipherInputStream(new FileInputStream(args[1]), cipher);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
                byte[] buf = new byte[16];
                int inLength = cis.read(buf);

                while (inLength > -1) {
                    baos.write(buf, 0, inLength);
                    inLength = cis.read(buf);
                }
                System.out.println("Print input content: ");
                System.out.println(new String(baos.toByteArray()));
            }
        }

    }

    /**
     * return
     *
     * @param algorithm
     * @return
     */
    public static Key genKey(String algorithm, String keyPath) throws NoSuchAlgorithmException, IOException {
        KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
        SecureRandom random = new SecureRandom();
        keygen.init(random);
        Key key = keygen.generateKey();

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(keyPath))) {
            out.writeObject(key);
        }

        return key;
    }

}
