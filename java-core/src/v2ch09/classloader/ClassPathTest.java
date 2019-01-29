package v2ch09.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassPathTest {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:/ray.sun/git/demo/java-core/bin/", "v2ch09/classloader", "Calculator.caesar");
        System.out.println("path=" + path);
        InputStream in = Files.newInputStream(path);
    }

}
