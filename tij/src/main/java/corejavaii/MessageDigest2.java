package corejavaii;

import cn.rs.demo.tij.util.ByteUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigest2 {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String letter = "“Upon my death, my property shall be divided equally among my children; however, " +
                "\nmy son George shall receive nothing.";
        MessageDigest alg = MessageDigest.getInstance("SHA-1");
        byte[] digest = alg.digest(letter.getBytes("UTF-8"));
        System.out.println("digest: " + ByteUtil.toHex(digest));
    }

}
