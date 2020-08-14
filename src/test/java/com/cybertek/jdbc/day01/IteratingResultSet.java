package com.cybertek.jdbc.day01;

import java.sql.*;

public class IteratingResultSet {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.93.69.55:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr,userName,password);

        Statement stmnt = connection.createStatement();

        ResultSet rs = stmnt.executeQuery("select * from regions");

        while (rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }

        rs.close();
        stmnt.close();
        connection.close();
    }
}
