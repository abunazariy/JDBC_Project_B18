package com.cybertek.jdbc.day03;

import com.cybertek.jdbc.Utility.Configuration_Reader;
import com.cybertek.jdbc.Utility.DB_Utility;

import java.sql.*;

public class Spartan_DB_Practice {
    public static void main(String[] args) throws SQLException {

        String connectionStr = Configuration_Reader.getProperty("db.url");
        String username = Configuration_Reader.getProperty("spartans.db.username");
        String password = Configuration_Reader.getProperty("spartans.db.password");

        DB_Utility.createConnection(connectionStr, username, password);
        DB_Utility.runQuery("select * from spartans");

        DB_Utility.getAllDataInMap();



        DB_Utility.destroy();


    }
}
