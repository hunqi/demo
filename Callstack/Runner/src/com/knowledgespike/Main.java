package com.knowledgespike;

import com.mantiso.DataAccess;
import com.pluralsight.DataService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataAccess access = new DataAccess("c:/temp/message.txt");
        DataService service = new DataService(access);
        service.write("Hello, World");
    }
}
