package com.testNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;

	@BeforeMethod
	public void LaunchingBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Installation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://www.google.com/");
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test (priority=0,groups="GoogleValidation")
	public void VerifyGoogleLOgo() {
		boolean a = driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
		if(a) {
			System.out.println("logo is displayed");
		}else {
			System.out.println("logo is not displayed");
		}
	}
	
	@Test (priority=1,groups="GoogleValidation")
	public void VerifyLuckyButton() {
		boolean T = driver.findElement(By.xpath("(//input[contains(@value,'Feeling Lucky')])[2]")).isDisplayed();
		if(T) {
			System.out.println("Lucky is displayed");
		}else {
			System.out.println("Lucky is not displayed");
		}
	}
	
	@Test (priority=2,groups="GoogleValidation")
	public void VerifyGmailLink() {
		boolean G=driver.findElement(By.xpath("//a[text()='Gmail']")).isEnabled();
		System.out.println(G);
	}
	
	@Test (groups="Chumma")
	public void Tett() {
		System.out.println("Testing");
	}
	
	@Test (groups="Chumma")
	public void Tett1() {
		System.out.println("Texting2");
	}
	
	
	
	@AfterMethod
	public void ClosingBrowser() {
		driver.close();
	}
}
