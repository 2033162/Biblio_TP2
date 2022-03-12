package ca.cal.bibliotheque.persistance.DB;

public class JDBCConfig {
    private static String JDBC_DRIVER = "org.h2.Driver";
    private static String DB_URL = "jdbc:h2:~/voyage";

    //  Database credentials
    private static String USER = "sa";
    private static String PASS = "";

    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getJdbcDriver() {
        return JDBC_DRIVER;
    }

    public static String getDbUrl() {
        return DB_URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }
}
