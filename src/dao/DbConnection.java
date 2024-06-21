package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static utility.DbConstants.*;
public class DbConnection {

    public  static Connection getDbConnection() throws SQLException {
        Connection con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        if(con==null) System.out.println("NOT Connected to Db");
        return con;
    }

}
