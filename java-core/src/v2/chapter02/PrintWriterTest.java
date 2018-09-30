package v2.chapter02;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintWriterTest {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println(System.getProperty("user.dir"));
        PrintWriter out = new PrintWriter("employees.dat", "UTF-8");

        out.print("Harry Hacker");
        out.print(" ");
        out.println(75000);
        out.close();
    }

}
