package com.Redipae.Utilities;

import com.Redipae.Testcases.AddUploadUser;
import com.Redipae.Testcases.Setup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteXLUtils extends AddUploadUser {


    static HSSFWorkbook workbook = new HSSFWorkbook();

    public static void UsermasterTestdatas() throws IOException, IOException {

        HSSFSheet sheet = workbook.createSheet("UserMasterDemo");


        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("UserName");
        sheet.getRow(0).createCell(1).setCellValue("FirstName");
        sheet.getRow(0).createCell(2).setCellValue("EmailID");
        sheet.getRow(0).createCell(3).setCellValue("Password");
        sheet.getRow(0).createCell(4).setCellValue("Roleid");
        sheet.getRow(0).createCell(5).setCellValue("Linkid");
        sheet.getRow(0).createCell(6).setCellValue("Status");

        Testdatas(sheet);
    }

    public static void Testdatas( HSSFSheet sheet) throws IOException {

      //Writing Testdatas

        String usermasterusername = GetRandomString();
        String usermasteremail = getrandomemail();
        sheet.createRow(1);
        sheet.getRow(1).createCell(0).setCellValue(usermasterusername);
        sheet.getRow(1).createCell(1).setCellValue("Ezhil");
        sheet.getRow(1).createCell(2).setCellValue(usermasteremail);
        sheet.getRow(1).createCell(3).setCellValue("test@123");
        sheet.getRow(1).createCell(4).setCellValue("3");
        sheet.getRow(1).createCell(5).setCellValue("15");
        sheet.getRow(1).createCell(6).setCellValue("TRUE");


        File file = new File("./Upload Files/UserMasterDemo.xls");
        FileOutputStream fos =  new FileOutputStream(file);
        workbook.write(fos);
        workbook.close();


    }
}




