package com.selenium.practice;

//Selenium script for automating gmail login, composing mail by uploading a file

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailAutomationLogic {
	
	static WebDriverWait wait;
	static String baseURL ="https://gmail.com";
	static WebElement userName;
	static WebElement password;
	static WebElement to;
	static WebElement subject;
	static WebElement body;

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		
	
		FileInputStream fin = new FileInputStream(new File("C:\\Users\\Karthik\\Desktop\\Subject.txt"));
        @SuppressWarnings("resource")
		java.util.Scanner scanner = new java.util.Scanner(fin,"UTF-8").useDelimiter("\\A");
        String theString = scanner.hasNext() ? scanner.next() : "";
        System.out.println(theString);
        scanner.close();
		
		
		System.setProperty("webdriver.gecko.driver", "E:\\Downloads\\Selenium_Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		userName = driver.findElement(By.id("identifierId"));
		userName.sendKeys("yourmail@gmail.com");
		
		driver.findElement(By.id("identifierNext")).click();
		
	 wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.name("password"))));
		
		password = driver.findElement(By.name("password"));
		password.sendKeys("your password");
		
		 wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(
							driver.findElement(By.id("passwordNext"))));
		
		driver.findElement(By.id("passwordNext")).click();
		
		//Element to click on Compose a mail
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		
		//Explicit wait condition to make element identify the To section and wait until it is clicked
	wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.className("vO"))));
				
		to = driver.findElement(By.className("vO"));
		to.sendKeys("toaddress@gmail.com");
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.className("aoT"))));
		
		subject = driver.findElement(By.className("aoT"));
		subject.sendKeys("My Updated Resume");
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@class = 'Am Al editable LW-avf']"))));
	
		body = driver.findElement(By.xpath("//*[@class = 'Am Al editable LW-avf']"));
		body.sendKeys(theString);
			
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@class = 'a1 aaA aMZ']"))));
		
		driver.findElement(By.xpath("//*[@class = 'a1 aaA aMZ']")).click();
			
	    Runtime.getRuntime().exec("D:\\AutoIT_Scripts\\script.exe");
		Thread.sleep(10000);
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(
						driver.findElement(By.xpath("//*[@class = 'T-I J-J5-Ji aoO T-I-atl L3']"))));
		
			driver.findElement(By.xpath("//*[@class = 'T-I J-J5-Ji aoO T-I-atl L3']")).click();
			
			   driver.close(); 
		    }
}