package v2ch05.exec;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Executes all sql statements in a file. call this program as
 * java -classpath driverPath:. ExecSQL commandFile
 */
public class ExecSQL {

    public static void main(String[] args) throws IOException {

        try (Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(System.getProperty("user.dir"), args[0]), "UTF-8")) {
            try (Connection conn = getConnection()) {
                Statement stat = conn.createStatement();
                while (true) {
                    if (args.length == 0) System.out.println("Enter command or EXIT to exit:");
                    if (!in.hasNextLine()) return;

                    String line = in.nextLine();
                    if (line.equalsIgnoreCase("EXIT")) return;
                    if (line.trim().endsWith(";")) { // remove trailing semicolon
                        line = line.trim();
                        line = line.substring(0, line.length() - 1);
                    }

                    try {
                        boolean isResult = stat.execute(line);
                        if (isResult) {
                            ResultSet rs = stat.getResultSet();
                            showResultSet(rs);
                        } else {
                            int updateCount = stat.getUpdateCount();
                            System.out.println(updateCount + " rows updated");
                        }
                    } catch (SQLException ex) {
                        for (Throwable e : ex)
                            e.printStackTrace();
                    }
                }

            } catch (SQLException e) {
                for (Throwable t : e)
                    t.printStackTrace();
            }
        }
    }

    /**
     * Prints a result set
     *
     * @param rs
     */
    private static void showResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i < columnCount; i++) {
            if (i > 1) System.out.print(", ");
            System.out.print(metaData.getColumnLabel(i));
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 1; i < columnCount; i++) {
                if (i > 1) System.out.print(", ");
                System.out.print(rs.getString(i));
            }
            System.out.println();
        }
    }

    /**
     * Gets a connection from the properties specified in the jdbc.properties file
     *
     * @return
     */
    private static Connection getConnection() throws IOException, SQLException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("jdbc.properties"))) {
            props.load(in);
        }

        String drivers = props.getProperty("jdbc.drivers");
        if (null != drivers) System.setProperty("jdbc.drivers", drivers);
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");

        return DriverManager.getConnection(url, username, password);
    }

}
