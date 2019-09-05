package cn.rs.demo.tij.strings;

import cn.rs.demo.tij.util.TextFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise 19: (8) Building on the previous two exercises,
 * write a program that examines Java source code and produces all the class names
 * used in a particular program.
 */
public class Exercise19 {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java absolute-souceCode-Path \ni.e., java D:\\source\\helloApp");
            System.exit(0);
        }


        String folder = args[0];
        if (Files.exists(Paths.get(args[0]))) {
            System.out.println("begin finding java types...");
            TreeSet<String> javaSourceFiles = new TreeSet<>();

            findJavaSourceFileName(javaSourceFiles, Paths.get(args[0]));
            System.out.println("end finding java types.");
            System.out.println("print all java types------");
            System.out.printf("total %d records\n", javaSourceFiles.size());

            int numOfSourceFile = 0;
            for (String t : javaSourceFiles) {
                if (t.endsWith(".java")) numOfSourceFile++;
                System.out.println("------ " + t);
            }

            System.out.printf("%d source files, %d dependency classes.\n",
                    numOfSourceFile,
                    javaSourceFiles.size() - numOfSourceFile);
        } else {
            System.out.printf("folder[%s] not exists, please provide a real path", args[0]);
        }
    }

    private static final ForkJoinPool pool = ForkJoinPool.commonPool();

    private static void findJavaSourceFileName(final TreeSet<String> javaSourceFiles, Path path) {

        if (Files.isDirectory(path)) {
            System.out.printf("traverse folder: %s\n", path);
            try {
                Files.walk(path).forEach(p -> {
                    if (!Files.isDirectory(p) && p.getFileName().toString().endsWith(".java")) {
                        javaSourceFiles.add(p.getFileName().toString());
                        findDependencyTypes(javaSourceFiles, p);
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void findDependencyTypes(final TreeSet<String> javaSourceFiles, final Path p) {
        pool.submit(() -> {
            Matcher m = Pattern.compile("import\\s+(\\w+\\.)+([A-Z][a-z0-9]*)+")
                    .matcher("");

            for (final String line : new TextFile(p.toString())) {
                m.reset(line);
                while (m.find()) {
                    if (m.group().indexOf("cn.homecredit.wechat.dd") < 0)
                        javaSourceFiles.add(m.group().replace("import ", ""));
                }
            }
        }).join();
    }
}
