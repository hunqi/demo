package tij.ch5.access.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionManager {

    private static Queue<Connection> connections;
    private static int count = 3;

    static {
        connections = new LinkedBlockingQueue<>();
        for (int i=0; i<3; i++)
            connections.add(new Connection());
    }

    public static Connection getConnection(){
        return connections.poll();
    }

}
