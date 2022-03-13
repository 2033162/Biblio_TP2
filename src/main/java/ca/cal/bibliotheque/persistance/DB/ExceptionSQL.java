package ca.cal.bibliotheque.persistance.DB;

import java.sql.SQLException;

public class ExceptionSQL {

    public static void handleException(Exception exception) {
        if (exception instanceof java.sql.SQLException sqlException) {
            System.out.println("Error Code: " + sqlException.getErrorCode());
            System.out.println("SQL State: " + sqlException.getSQLState());
        }
        System.out.println("SQLException message: " + exception.getMessage());
        System.out.println("Stacktrace: ");
        exception.printStackTrace();
    }
}
