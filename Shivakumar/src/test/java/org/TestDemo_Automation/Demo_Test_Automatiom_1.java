package org.TestDemo_Automation;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class Demo_Test_Automatiom_1 {

    static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Demo_Test_Automatiom_1.class);

    @BeforeClass
    public void setup() {
        logger.info("Setting up the browser");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chethan Kumar\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void login() {
        logger.info("Starting login test");
        try {
            driver.get("https://online.actitime.com/synamedia/timetrack/enter.do");
            logger.info("Navigated to Actitime login page");

            driver.findElement(By.id("username")).sendKeys("chethankumarklk23@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@class='textField pwdfield']")).sendKeys("CHET1996@");
            Thread.sleep(3000);
            driver.findElement(By.id("loginButton")).click();
            logger.info("Login submitted");

            attachScreenshot("Login Screen");
        } catch (Exception e) {
            logger.error("Login failed", e);
            attachScreenshot("Login Failed");
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 2)
    public void create_customer() {
        logger.info("Creating new customer");
        try {
            driver.findElement(By.xpath("//div[text()='Tasks']")).click();
            Thread.sleep(1000);
            driver.findElement(By.className("addNewButton")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='New Customer']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@class='inputFieldWithPlaceholder newNameField inputNameField']")).sendKeys("TataSky");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys("TataSky T51 - CR Changes Release build 302");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
            Thread.sleep(1000);

            logger.info("Customer 'TataSky' created successfully");
            attachScreenshot("Customer Created");

        } catch (Exception e) {
            logger.error("Failed to create customer", e);
            attachScreenshot("Customer Creation Failed");
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void delete_customer() {
        logger.info("Deleting customer");
        try {
            driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']//div[@class='editButton']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='ACTIONS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='content_customerPanel']//following-sibling::div[@class='dropdownContainer actionsMenu']//child::div[@class='deleteButton']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@class='blockedWarningContainer']//following-sibling::div[@class='buttonsContainer']//child::div[@class='submitBtn commitBtn greyButton']//span[text()='Delete permanently']")).click();
            Thread.sleep(2000);

            logger.info("Customer deleted successfully");
            attachScreenshot("Customer Deleted");

        } catch (Exception e) {
            logger.error("Failed to delete customer", e);
            attachScreenshot("Customer Deletion Failed");
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        logger.info("Closing browser");
        if (driver != null) {
            driver.quit();
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
