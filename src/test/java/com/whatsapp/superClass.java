package com.whatsapp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.XMLFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class superClass {

    public WebDriverWait wait;
    String returnValue;
    public Actions action;
    int randomInteger;

    public WebDriverWait getwaitdriver(WebDriver driver) {
        if (wait == null) {
            wait = new WebDriverWait(driver, 10);
            return wait;
        } else {
            return wait;
        }
    }

    public Actions getActionDriver(WebDriver driver) {
        if (action == null) {
            action = new Actions(driver);
            return action;
        } else {
            return action;
        }

    }

    public String getValueFromDataConfig(String value) throws IOException {

        FileReader reader = new FileReader("./src/test/java/resources/Data.properties");

        Properties p = new Properties();
        p.load(reader);

        returnValue = p.getProperty(value);
        return returnValue;

    }

    public By getValueFromElementAddressConfig(String value) throws IOException {
        FileReader reader = new FileReader("./src/test/java/resources/elementAddress.properties");

        Properties p = new Properties();
        p.load(reader);

        returnValue = p.getProperty(value);

        By elementByAddress = By.xpath(returnValue);

        // WebElement elementAddress = driver.findElement(By.xpath(returnValue));
        return elementByAddress;

    }

    public static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    public void setLogger(String log) throws Exception {

        // Creating an object of XMLFormatter class
        XMLFormatter xmlFormatter = new XMLFormatter();

        // Setting level to Info
        LogRecord logRecord = new LogRecord(Level.INFO, "Logrecord message to be printed in xml file..");
        logRecord.setMessage(log);

        // We can see the output of LogRecord in
        // logrecordxml.xml file
        FileHandler fileHandler = new FileHandler("logrecordxml.xml");
        fileHandler.setFormatter(xmlFormatter);

        // Prepared data is displayed in the
        // logrecordxml.xml file
        fileHandler.publish(logRecord);

        // Lastly releasing out all the records
        // using the flush() method
        fileHandler.flush();
    }

    public String getcurrrentDateAndTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        return dtf.format(now);

    }

    public int getrandomvalue(int from, int to) {

        for (int i = 0; i < 1; i++) {
            Random random = new Random();
            randomInteger = random.nextInt(to);
            if (randomInteger == 0) {
                randomInteger = randomInteger + 1;
            }
            System.out.println("int in a range : " + randomInteger);
        }
        return randomInteger;

    }

}
