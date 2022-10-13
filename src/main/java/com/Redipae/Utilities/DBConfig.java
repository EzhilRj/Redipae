package com.Redipae.Utilities;

import java.sql.*;

public class DBConfig {

    public static boolean ConnectDB(String query, String Columnname, String un) throws ClassNotFoundException, SQLException {

        String Databaseurl = "jdbc:sqlserver://183.83.187.133\\FIELDLYTICSDEVS:1433;DatabaseName=Redipaetest;encrypt=true;trustServerCertificate=true";
        String Dbusername = "Fieldlytics2021";
        String Dbpassword = "PPMSdevserver$2022";


        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection connection = DriverManager.getConnection(Databaseurl, Dbusername, Dbpassword);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);

        String name = "";
        boolean val;
        while (rs.next()) {

            name = rs.getString(Columnname);

        }
        val = name.equalsIgnoreCase(un) ? true : false;



        return val;


    }


}
