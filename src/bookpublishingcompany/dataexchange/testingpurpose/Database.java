package bookpublishingcompany.dataexchange.testingpurpose;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;
    private final static String host = "remotemysql.com:3306";
    private final static String user = "9LLVL39k5B";
    private final static String password = "FFJfg4TwJ1";

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                connection = DriverManager.getConnection("jdbc:mysql://" + host+"?autoReconnect=true&useSSL=false", user, password);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
        connection=null;
    }
}
