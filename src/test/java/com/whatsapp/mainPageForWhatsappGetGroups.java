package com.whatsapp;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import java.io.File;

import java.awt.event.KeyEvent;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.record.formula.functions.Column;
import org.apache.poi.hssf.record.formula.functions.If;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.python.modules.thread.thread;

import scala.collection.GenTraversable;
import scala.sys.process.ProcessBuilderImpl.FileOutput;

public class mainPageForWhatsappGetGroups extends superClass {

    String GroupNameinfor = "";
    String GroupNameinfor1 = "";
    String ContactOrGroupName;
    String typeInfo;

    // public void getgroupname(WebDriver driver, int count) throws IOException,
    // InterruptedException, AWTException {

    // getwaitdriver(driver).until(
    // ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.searchbox")));
    // driver.findElement(getValueFromElementAddressConfig("whatsapp.searchbox")).click();
    // Thread.sleep(1000);

    // for (int i = 0; i <= count; i++) {

    // getRobotdriver().keyPress(KeyEvent.VK_DOWN);

    // getwaitdriver(driver).until(ExpectedConditions
    // .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.getGroupName")));
    // Thread.sleep(1000);
    // String ContactOrGroupName =
    // driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName"))
    // .getAttribute("title");
    // //
    // System.out.println(driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName")).getAttribute("title"));

    // driver.findElement(getValueFromElementAddressConfig("whatsapp.clickmenu")).click();
    // Thread.sleep(1000);
    // String typeInfo =
    // driver.findElement(getValueFromElementAddressConfig("whatsapp.getinfo")).getText();
    // //
    // System.out.println(driver.findElement(getValueFromElementAddressConfig("whatsapp.getinfo")).getText());
    // String outputtext = ContactOrGroupName + "\t" + typeInfo + "\n";
    // System.out.println(outputtext);
    // getRobotdriver().keyPress(KeyEvent.VK_ESCAPE);
    // Thread.sleep(1000);

    // GroupNameinfor = GroupNameinfor.concat(outputtext);
    // System.out.println(GroupNameinfor);

    // }

    // try {
    // FileWriter fw = new FileWriter("C:\\GitProject\\Output.txt");
    // fw.write(GroupNameinfor);
    // fw.close();
    // } catch (Exception e) {
    // System.out.println(e);
    // }

    // }

    public void resultinexcel(WebDriver driver, int count1) throws IOException, InterruptedException, AWTException {

        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.searchbox")));
        driver.findElement(getValueFromElementAddressConfig("whatsapp.searchbox")).click();
        Thread.sleep(1000);

        for (int i = 0; i <= count1; i++) {
            
            //Down key action
            getRobotdriver().keyPress(KeyEvent.VK_DOWN);
            
            //Fetching whatsapp contact name
            getwaitdriver(driver).until(ExpectedConditions
                    .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.getGroupName")));
            Thread.sleep(1000);
            ContactOrGroupName = driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName"))
                    .getAttribute("title");
            
            //Getting contact info from Menu
            driver.findElement(getValueFromElementAddressConfig("whatsapp.clickmenu")).click();
            Thread.sleep(1000);
            typeInfo = driver.findElement(getValueFromElementAddressConfig("whatsapp.getinfo")).getText();

            // Escape action
            getRobotdriver().keyPress(KeyEvent.VK_ESCAPE);
            Thread.sleep(1000);

            try {

                //checking file exist in location
                File file = new File("C:\\GitProject\\Testdata.xlsx");
                if (file.exists()) {
                    
                    //Saving the output in the given location
                    FileInputStream fis = new FileInputStream("C:\\GitProject\\Testdata.xlsx");
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheet("Din");

                    Row row = sheet.createRow(i);
                    Cell cell = row.createCell(0);
                    Cell cell1 = row.createCell(1);

                    cell.setCellType(cell.CELL_TYPE_STRING);
                    cell.setCellValue(ContactOrGroupName);
                    cell1.setCellValue(typeInfo);

                    //Column auto size
                    sheet.autoSizeColumn(0);
                    sheet.autoSizeColumn(1);

                    FileOutputStream fos = new FileOutputStream("C:\\GitProject\\Testdata.xlsx");
                    workbook.write(fos);
                    fos.close();
                } else {
                    System.out.println("file not exist");
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

}