package Servlets;

import java.sql.*;
import java.lang.*;

/**
 * Created by shaan on 26/6/17.
 */
public class DbClass {


    public static Connection conn() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ttn", "root", "Root001#");
        return con;
    }
}
