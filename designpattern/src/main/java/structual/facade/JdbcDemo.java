package structual.facade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {

    public static void main(String[] args) throws SQLException {

        DbSingleton instance = DbSingleton.getInstance();

        try (Connection conn = instance.getConnection()) {
            Statement sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE Address (ID Integer, Streename VARCHAR(20), City VARCHAR(20))");

            System.out.println("Table created.");
            sta.close();

            sta = conn.createStatement();
            count = sta.executeUpdate("INSERT into Address (ID, Streename, City) " +
                    "values (1, '1234 Some Street', 'Shenzhen')");
            System.out.println(count + " record(s) created");
            sta.close();

            sta = conn.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM Address");

            while (rs.next()) {
                System.out.printf("%s %s %s\n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }

        }

    }

}
