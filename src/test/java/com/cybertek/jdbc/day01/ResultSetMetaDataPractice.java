package com.cybertek.jdbc.day01;

import java.sql.*;

public class ResultSetMetaDataPractice {
    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@3.93.69.55:1521:XE";
        String userName = "hr";
        String password = "hr";

        Connection connection = DriverManager.getConnection(connectionStr,userName,password);

        Statement stmnt = connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmnt.executeQuery("select * from employees");

        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();


        for (int i = 1; columnCount>=i;  i++){
            System.out.println(i+" "+rsmd.getColumnName(i));
        }




        rs.close();
        stmnt.close();
        connection.close();











    }
}
