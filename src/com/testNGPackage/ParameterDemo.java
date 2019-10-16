package com.testNGPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterDemo {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"url"})
	public void LaunchChrome(String url) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(url);
		
	}

	@Test
	@Parameters({"username"})
	public void login(String Userid) {
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Sign in')])[2]")).click();
		Set<String> windows= driver.getWindowHandles();
		Iterator it = windows.iterator();
		String ParentWindow = (String) it.next();
		System.out.println(ParentWindow);
		String ChildWindow = (String) it.next();
		System.out.println(ChildWindow);
		driver.switchTo().window(ChildWindow);
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(Userid);
		driver.findElement(By.xpath("//span[text()='Next']"));
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	
}
