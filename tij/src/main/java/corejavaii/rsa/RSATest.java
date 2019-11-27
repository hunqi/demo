package corejavaii.rsa;

import cn.rs.demo.tij.util.aes.Util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

/**
 * This program tests the RSA cipher.
 * Usage:
 * java rsa.RSATest -genkey public private
 * java rsa.RSATest -encrypt plaintext encrypted public
 * java rsa.RSATest -decrypt encrypted decrypted private
 */
public class RSATest {

    private static final int KEY_SIZE = 512;

    public static void main(String[] args) throws Exception {
        if (args[0].equals("-genkey")) {
            System.out.println("begin generating key pairsss");
            KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = new SecureRandom();
            pairgen.initialize(KEY_SIZE, random);
            KeyPair keyPair = pairgen.genKeyPair();

            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1]))) {
                out.writeObject(keyPair.getPublic());
            }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[2]))) {
                out.writeObject(keyPair.getPrivate());
            }
            System.out.println("key pair generated");
        } else if (args[0].equals("-encrypt")) {
            System.out.println("begin encryption");
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();

            //wrap with RSA public key
            try (ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                 DataOutputStream out = new DataOutputStream(new FileOutputStream(args[2]));
                 InputStream in = new FileInputStream(args[1])) {
                Key publicKey = (Key) keyIn.readObject();
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.WRAP_MODE, publicKey);
                byte[] wrappedKey = cipher.wrap(key);
                out.writeInt(wrappedKey.length);
                out.write(wrappedKey);

                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, key);
                Util.crypt(in, out, cipher);
            }
            System.out.println("encryption finished");
        } else {
            System.out.println("begin decryption");
            try (DataInputStream in = new DataInputStream(new FileInputStream(args[1]));
                 ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
                 PrintWriter out = new PrintWriter(args[2], "UTF-8");
            ) {
                int length = in.readInt();
                byte[] wrappedKey = new byte[length];
                in.read(wrappedKey, 0, length);

                //unwrap with RSA private key
                Key privateKey = (Key) keyIn.readObject();

                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.UNWRAP_MODE, privateKey);
                Key key = cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);

                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, key);

                Util.crypt(in, out, cipher);
            }
            System.out.println("decryption finished");
        }

        System.out.println("--- done ---");
    }

}
