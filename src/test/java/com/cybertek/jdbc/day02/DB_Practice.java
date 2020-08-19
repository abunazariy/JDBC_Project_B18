package com.cybertek.jdbc.day02;

import com.cybertek.jdbc.DB_Utility;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class DB_Practice {
    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("select * from departments");


        DB_Utility.destroy();


    }
}
