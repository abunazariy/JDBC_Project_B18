package com.cybertek.jdbc.day01;

import java.sql.*;

public class ReversedOrder {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.93.69.55:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr,userName,password);

        Statement stmnt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmnt.executeQuery("select * from countries");


        rs.afterLast();
        while (rs.previous()){
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        }

        rs.last();

        System.out.println("rs.getRow() = " + rs.getRow()); // to check what is current row


        rs.close();
        stmnt.close();
        connection.close();











    }
}
