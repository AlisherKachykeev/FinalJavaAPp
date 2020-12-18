package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DB_handler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://127.0.0.1/root" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(String firstName, String lastName, String userName, String password, String location, String gender){
        String insert = "INSERT INTO " + Constants.USER_TABLE + "(" + Constants.USERS_FIRSTNAME + "," +
                Constants.USERS_LASTNAME + "," + Constants.USERS_USERNAME + "," + Constants.USERS_PASSWORD + "," +
                Constants.USERS_LOCATION + "," + Constants.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = null;
            try {
                prSt = getDbConnection().prepareStatement(insert);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            prSt.setString(1, firstName);
            prSt.setString(2, lastName);
            prSt.setString(3, userName);
            prSt.setString(4, password);
            prSt.setString(5, location);
            prSt.setString(6, gender);
            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
