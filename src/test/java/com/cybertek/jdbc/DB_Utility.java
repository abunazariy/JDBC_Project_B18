package com.cybertek.jdbc;

import java.sql.*;
import java.util.*;

public class DB_Utility {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;

    public static void createConnection(){
        String connectionStr = "jdbc:oracle:thin:@3.93.69.55:1521:xe";
        String username = "hr";
        String password = "hr";

        try {
            connection = DriverManager.getConnection(connectionStr, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet runQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rs;
    }

    public static int getRowCount(){
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
            rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowCount;
    }

    public static int getColumnCount(){
        int columnCount = 0;

        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnCount;
    }

    public static void getAllData(){

        int columnCount = DB_Utility.getColumnCount();
        try {
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
            }
            rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<String> getWholeRow(int rowNumber){
        List<String> row = new ArrayList<>();
        try {
            rs.beforeFirst();
            rs.absolute(rowNumber);
        for (int i = 1; i <= getColumnCount(); i++) {
            row.add(rs.getString(i));
        }
            System.out.println();
        rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return row;
    }

    public static void getWholeColumn(int columnNumber){
        try{
            rs.beforeFirst();
        while (rs.next()) {
            System.out.println(rs.getString(columnNumber));
        }
        rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static String getColumnDataAtRow(int rowNum, int columnIndex){
        String str ="";
        try {
            rs.absolute(rowNum);
            str = rs.getString(columnIndex);
            rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return str;
    }

    public static void getAllDataInMap(){

        Map<String, String> map = new HashMap<>();
        try {
            rsmd = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 1; i <= getColumnCount(); i++) {
                    map.put(rsmd.getColumnName(i), rs.getString(i));
                }
                System.out.println(map);
            }
            rs.beforeFirst();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void destroy(){
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
