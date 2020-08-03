package structual.facade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {

    private static DbSingleton instance;

    private DbSingleton() {

    }

    public static DbSingleton getInstance() {
        if (null == instance)
            instance = new DbSingleton();
        return instance;
    }

    public Connection getConnection() throws SQLException {
        System.setProperty("jdbc.drivers", "org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1", "ray", "");
    }

    public static void main(String[] args) throws SQLException {
        DbSingleton db = DbSingleton.getInstance();
        System.out.println(db.getConnection() == db.getConnection());
    }

}
