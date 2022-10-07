package com.Redipae.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {

        File src = new File("./src/main/resources/Configuration/RedipaeConfig.properties");

        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {

            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String GetBrowser() {

        String browser = pro.getProperty("Browser");
        return browser;

    }

    public String getapplicationURL() {

        String Url = pro.getProperty("BaseURL");
        return Url;

    }

    public String GetUsername() {

        String Username = pro.getProperty("Username");
        return Username;

    }

    public String GetPassword() {

        String password = pro.getProperty("Password");
        return password;

    }


    public String Downloadingpath() {

        String downpath = pro.getProperty("downloadinglocation");
        return downpath;

    }

    public String Uploadingpath() {

        String Uploadpath = pro.getProperty("UploadFilesLocation");
        return Uploadpath;

    }

}
