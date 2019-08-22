package cn.rs.demo.tij.strings;

import cn.rs.demo.tij.util.TextFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Exercise 16: (5) Modify JGrep.java to accept a directory name or a file name as argument
// (if a directory is provided, search should include all files in the directory)

//: strings/JGrep.java
// A very simple version of the "grep" program.
// {Args: JGrep.java "\\b[Ssct]\\w+"}
public class JGrep3 {

    public static void main(String[] args) throws IOException {

        if (args.length < 3) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }

        if (Files.isDirectory(Paths.get(args[0]))) {
            File[] files = Paths.get(args[0]).toFile().listFiles();

            System.out.println("files.size: " + files.length);
            for (File f : files){
                System.out.println("File: " + f.getName());
                display(args, f.getAbsolutePath());
                System.out.println();
            }

        } else {
            display(args, args[0]);
        }
    }

    private static void display(String[] args, String filename) {
        Pattern p = Pattern.compile(args[2] + args[1]);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        for (String line : new TextFile(filename)) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " +
                        m.group() + ": " + m.start());
        }
    }

}
