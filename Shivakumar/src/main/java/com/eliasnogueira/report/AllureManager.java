package com.eliasnogueira.report;

import com.github.automatedowl.tools.AllureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AllureManager {

    private static WebDriver driver;

    private AllureManager() {}

    // Hardcoded WebDriver setup
    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with actual path
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void setAllureEnvironmentInformation() {
        AllureEnvironmentWriter.allureEnvironmentWriter(
            ImmutableMap.<String, String>builder()
                .put("Test URL", "https://example.com")
                .put("Target execution", "local")
                .put("Global timeout", "10")
                .put("Headless mode", "false")
                .put("Faker locale", "en-US")
                .put("Local browser", "chrome")
                .put("Grid URL", "http://localhost")
                .put("Grid port", "4444")
                .build()
        );
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public static byte[] takeScreenshotToAttachOnAllureReport() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Browser information", type = "text/plain")
    public static String addBrowserInformationOnAllureReport() {
        WebDriver d = getDriver();
        return String.format("Browser: Chrome\nURL: %s", d.getCurrentUrl());
    }

    // Cleanup method (optional)
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
