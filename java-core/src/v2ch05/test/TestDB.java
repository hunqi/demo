package v2ch05.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * This program demonstrates accessing database by DriverManager
 */
public class TestDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        try (Connection conn = getConnection()) {
            Statement statement = conn.createStatement();
            statement.executeUpdate("CREATE TABLE Greetings(Message CHAR(20))");
            statement.executeUpdate("INSERT INTO Greetings VALUES('Hello,World!')");

            try (ResultSet result = statement.executeQuery("SELECT * FROM Greetings")) {
                if (result.next())
                    System.out.println(result.getString(1));
            }

            statement.executeUpdate("DROP TABLE Greetings");
        }
    }

    private static Connection getConnection() throws IOException, SQLException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(System.getProperty("user.dir"), "src/v2ch05/test", "jdbc.properties"))) {
            props.load(in);
        }

        String drivers = props.getProperty("jdbc.drivers");
        if (null != drivers) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        //derby no needs username/password
//        String username = props.getProperty("jdbc.username");
//        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url);
    }

}
