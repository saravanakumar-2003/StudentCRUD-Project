/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcrud.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ssara
 */
public class StudentUtil {
    
    public Connection connection() throws ClassNotFoundException, SQLException{
        Connection conn;
        String url = "jdbc:mysql://localhost:3306/StudentCrud";
        String user = "root";
        String password = "Sharu@1229";



        //Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //Establish connection
        conn = DriverManager.getConnection(url,user,password);
        System.out.println("Connected to MySQL database");
        return conn;
    }
}
