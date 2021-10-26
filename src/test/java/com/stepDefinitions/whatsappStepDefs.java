package com.stepDefinitions;

import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.io.IOException;
import com.whatsapp.mainPageForWhatsappGetGroups;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
public class whatsappStepDefs extends mainPageForWhatsappGetGroups {

    WebDriver driver;

    @Given("^Access WebDriverManager$")
    public void access_WebdriverManager() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        // options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        // driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Then("^Launch chrome \"([^\"]*)\" browser$")
    public void launch_chrome_browser_for_whatsappweb(String url) throws IOException {
        // Launching sample website
        driver.get(getValueFromDataConfig(url));

        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    // @Then("^click main menu in whatsappweb$")
    // public void click_main_menu_in_whatsappweb() throws IOException {
    // // click on mainmenu in homespage
    // clickmenubutton(driver);
    // }

    // @Then("^get the groupname for whatsappweb$")
    // public void get_the_groupname() throws IOException, InterruptedException,
    // AWTException {
    // getgroupname(driver);
    // }

    // @Then("^get contact info for whatsappweb$")
    // public void get_contact_info() throws IOException, InterruptedException,
    // AWTException {
    // getgroupname(driver);

    // @Then("^change output to text file$")
    // public void change_output_to_text_file() throws IOException {
    // dinesh(driver);
    // }

    @Then("^get the \"([^\"]*)\" groupname for whatsappweb$")
    public void get_the_groupname(int count) throws IOException, InterruptedException, AWTException {
        getgroupname(driver, count);
    }

}
