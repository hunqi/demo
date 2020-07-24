package com.mantiso;

import java.io.FileWriter;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class DataAccess {

    private String fileName;

    public DataAccess(String fileName) {
        this.fileName = fileName;
    }

    public void write(String message) {

        AccessController.doPrivileged((PrivilegedAction)() -> {
            try (FileWriter writer = new FileWriter(fileName)){
                writer.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });

    }
}
