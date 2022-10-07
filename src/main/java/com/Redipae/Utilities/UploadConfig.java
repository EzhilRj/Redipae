package com.Redipae.Utilities;

import com.Redipae.Testcases.Setup;
import org.apache.log4j.Logger;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadConfig extends Setup {

    public static String uploadfile(String Path) throws AWTException, InterruptedException {

        //Aadhar front image
        Logger log = Logger.getLogger("OnboardingLogs");

        Thread.sleep(800);
        Robot robot = new Robot();
        log.info("Filemanager Window is Opened");
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(500);
        log.info("Image path is Copied");
        StringSelection image = new StringSelection(Path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(image, null);
        log.info("Image path is Pasted");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(100);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        log.info("Image is Uploaded");


        return image.toString();
    }

}