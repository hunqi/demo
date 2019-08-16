package cn.rs.demo.tij.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFile extends ArrayList<String> {

    // Read a file as a single string
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {

            if (Files.exists(Paths.get(fileName))) {
                readFileContent(sb, Paths.get(fileName).toFile());
            } else {
                Files.walk(Paths.get(System.getProperty("user.dir"))).forEach(path -> {
                    if (!Files.isDirectory(path) && path.getFileName().endsWith(fileName)) {
                        readFileContent(sb, path.toFile());
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    private static void readFileContent(StringBuilder sb, File file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Write a single file in one method call:
    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Read a file, split by any regular expression:
    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
// Regular expression split() often leaves an empty
// String at the first position:
        if (get(0).equals("")) remove(0);
    }

    // Normally read by lines:
    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Simple test:
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        Files.walk(Paths.get(System.getProperty("user.dir"))).forEach(p -> {
            if (!Files.isDirectory(p) && p.getFileName().endsWith("TextFile.java"))
                System.out.println(p.getFileName());

        });
    }

}
