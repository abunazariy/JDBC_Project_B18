package com.cybertek.jdbc.day02;

import com.cybertek.jdbc.Utility.DB_Utility;

import java.sql.*;
import java.sql.SQLException;

public class DB_Practice {
    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("select * from departments");

        DB_Utility.getAllDataInMap();

        DB_Utility.destroy();


    }
}
