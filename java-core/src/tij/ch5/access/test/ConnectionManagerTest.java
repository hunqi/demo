package tij.ch5.access.test;

import tij.ch5.access.connection.Connection;
import tij.ch5.access.connection.ConnectionManager;

public class ConnectionManagerTest {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Connection conn = ConnectionManager.getConnection();
            if (null == conn)
                System.out.println("No connection is available.");
            else
                System.out.println("Connection got successfully.");
        }

    }

}
