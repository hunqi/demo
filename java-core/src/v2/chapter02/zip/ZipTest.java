package v2.chapter02.zip;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipTest {

    public static void main(String[] args) throws IOException {
        String zipName = args[0];
        showContents(zipName);
        System.out.println("---");
        showContents2(zipName);
    }

    private static void showContents(String zipName) throws IOException {
        // Here, we use the classic zip API
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println(entry.getName());

                Scanner in = new Scanner(zin, "UTF-8");
                while (in.hasNextLine())
                    System.out.println("   " + in.nextLine());
                zin.closeEntry();
            }
        }
    }

    private static void showContents2(String zipName) throws IOException {
        // Here, we make a Java SE 7 file system
        FileSystem fs = FileSystems.newFileSystem(Paths.get(zipName), null);
        Files.walkFileTree(fs.getPath("/"), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                for (String line : Files.readAllLines(file, Charset.forName("UTF-8")))
                    System.out.println("   " + line);
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
