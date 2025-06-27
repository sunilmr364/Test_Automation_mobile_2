package org.TestDemo_Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo_Test_Automatiom_1 {
	
	static WebDriver driver;
	@Test
	// Login
	public static void Login() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chethan Kumar\\eclipse-workspace\\Automation\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();	
        driver.get("https://online.actitime.com/synamedia/timetrack/enter.do");
      //  https://online.actitime.com/synamedia/timetrack/enter.do
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("chethankumarklk23@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='textField pwdfield']")).sendKeys("CHET1996@");
        Thread.sleep(3000);
        driver.findElement(By.id("loginButton")).click();
	}
        
	@Test	 
		// Create Customer
	public static void create_customer() throws InterruptedException
	{
		// WebDriver driver=null;
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
	}
	@Test
	// Delete Customer
	public static void delete_customer() throws InterruptedException
	{
		//WebDriver driver=null; 

	      driver.findElement(By.xpath("//div[@class='titleEditButtonContainer']//div[@class='editButton']")).click(); 
	      Thread.sleep(1000);
		  driver.findElement(By.xpath("//div[text()='ACTIONS']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@class='content_customerPanel']//following-sibling::div[@class='dropdownContainer actionsMenu']//child::div[@class='deleteButton']")).click();
		  Thread.sleep(1000);		  
		  driver.findElement(By.xpath("//*[@class='blockedWarningContainer']//following-sibling::div[@class='buttonsContainer']//child::div[@class='submitBtn commitBtn greyButton']//span[text()='Delete permanently']")).click();
		 Thread.sleep(2000);
		 driver.close();
        } 

}
