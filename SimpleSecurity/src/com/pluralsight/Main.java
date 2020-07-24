package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String home = System.getProperty("user.home");
        System.out.println(home);

        try (FileWriter writer = new FileWriter(home + "/out.txt")) {
            writer.write("Hello, world");
        }
    }
}
