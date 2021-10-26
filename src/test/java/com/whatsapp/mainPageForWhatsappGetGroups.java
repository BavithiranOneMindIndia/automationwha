package com.whatsapp;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.python.modules.thread.thread;

import scala.collection.GenTraversable;

public class mainPageForWhatsappGetGroups extends superClass {

    String GroupNameinfor = "";
    // public void clickmenubutton(WebDriver driver) throws IOException {
    // getwaitdriver(driver).until(
    // ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.homemenu")));
    // driver.findElement(getValueFromElementAddressConfig("whatsapp.homemenu")).click();

    // }

    // public void clickfirstmessage(WebDriver driver) throws IOException {
    // getwaitdriver(driver).until(
    // ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.name")));
    // driver.findElement(getValueFromElementAddressConfig("whatsapp.name")).click();
    // }

    public void getgroupname(WebDriver driver, int count) throws IOException, InterruptedException, AWTException {

        getwaitdriver(driver).until(
                ExpectedConditions.visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.searchbox")));
        driver.findElement(getValueFromElementAddressConfig("whatsapp.searchbox")).click();
        Thread.sleep(1000);

        for (int i = 0; i <= count; i++) {

            getRobotdriver().keyPress(KeyEvent.VK_DOWN);

            getwaitdriver(driver).until(ExpectedConditions
                    .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.getGroupName")));
            Thread.sleep(1000);
            String ContactOrGroupName = driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName"))
                    .getAttribute("title");
            // System.out.println(driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName")).getAttribute("title"));

            driver.findElement(getValueFromElementAddressConfig("whatsapp.clickmenu")).click();
            Thread.sleep(1000);
            String typeInfo = driver.findElement(getValueFromElementAddressConfig("whatsapp.getinfo")).getText();
            // System.out.println(driver.findElement(getValueFromElementAddressConfig("whatsapp.getinfo")).getText());
            String outputtext = ContactOrGroupName + "\t" + typeInfo + "\n";
            System.out.println(outputtext);
            getRobotdriver().keyPress(KeyEvent.VK_ESCAPE);
            Thread.sleep(1000);

            GroupNameinfor = GroupNameinfor.concat(outputtext);
            System.out.println(GroupNameinfor);

            // String output = "Contactinfor.txt";
            // final boolean append = true, autoflush = true;
            // PrintStream ps = new PrintStream(new FileOutputStream(output, append),
            // autoflush);
            // System.setOut(ps);

        }

        // System.out.println(GroupNameinfor);

        try {
            FileWriter fw = new FileWriter("C:\\GitProject\\Output.txt");
            fw.write(GroupNameinfor);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // public void getChatNames(WebDriver driver) throws InterruptedException,
    // AWTException, IOException {

    // Thread.sleep(2000);

    // // getActionDriver(driver).keyDown(Keys.ARROW_DOWN);

    // Robot robot = new Robot();

    // robot.keyPress(KeyEvent.VK_DOWN); //auto found this value

    // Thread.sleep(1000);

    // getwaitdriver(driver).until(ExpectedConditions

    // .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.getGroupName")));

    // System.out.println(

    // driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName")).getAttribute("title"));

    // }

}