package com.Redipae.Utilities;

import java.sql.*;

public class DBConfig {

    static String Databaseurl = "jdbc:sqlserver://183.83.187.133\\FIELDLYTICSDEVS:1433;DatabaseName=Redipaetest;encrypt=true;trustServerCertificate=true";
    static String Dbusername = "Fieldlytics2021";
    static String Dbpassword = "PPMSdevserver$2022";


    public static boolean ConnectDB(String query, String Columnname, String un) throws ClassNotFoundException, SQLException {


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

    public static boolean connectdb2(String query, String un) throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        Connection connection = DriverManager.getConnection(Databaseurl, Dbusername, Dbpassword);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(query);


        String rowcount = "";
        boolean val2;
        while (rs.next()) {

            rowcount = String.valueOf(rs.getRow());

        }
        val2 = rowcount.equals("2") ? true : false;




        return val2;
    }


}