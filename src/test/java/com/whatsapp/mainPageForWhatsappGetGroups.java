package com.whatsapp;

import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class mainPageForWhatsappGetGroups extends superClass {

    public void clickSearchField(WebDriver driver) throws IOException {
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.searchfield")));
        driver.findElement(getValueFromElementAddressConfig("whatsapp.searchfield")).click();

    }

    public void getChatNames(WebDriver driver) throws InterruptedException, IOException, AWTException {

        Thread.sleep(2000);
        //getActionDriver(driver).keyDown(Keys.ARROW_DOWN);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(1000);
        getwaitdriver(driver).until(ExpectedConditions
                .visibilityOfElementLocated(getValueFromElementAddressConfig("whatsapp.getGroupName")));

        System.out.println(
                driver.findElement(getValueFromElementAddressConfig("whatsapp.getGroupName")).getAttribute("title"));

    }

}
