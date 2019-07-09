package cn.rs.demo.tij.str;

import java.io.*;
import java.nio.file.Files;

public class Hex {

    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;
        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0)
// Test by displaying this class file:
            System.out.println(
                    format(BinaryFile.read("Hex.class")));
        else
            System.out.println(
                    format(BinaryFile.read(new File(args[0]))));
    }

}

class BinaryFile {
    public static byte[] read(String filename) throws IOException {
        return read(new File(filename));
    }

    public static byte[] read(File file) throws IOException {
        try (InputStream is = Files.newInputStream(file.toPath());
             BufferedInputStream bis = new BufferedInputStream(is);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buf = new byte[1024];
            int i = -1;
            while ((i = bis.read(buf)) != -1) {
                bis.read();
                baos.write(buf, 0, buf.length);
            }

            return baos.toByteArray();
        }
    }

    public static void main(String[] args) throws IOException {
        File file = new File("");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        ClassLoader classLoader = BinaryFile.class.getClassLoader();
        System.out.println(classLoader.getResource("."));
    }
}