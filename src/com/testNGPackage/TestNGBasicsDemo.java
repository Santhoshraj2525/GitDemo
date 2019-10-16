package com.testNGPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasicsDemo {
	
	@BeforeSuite
	public void SetProperty() {
		System.out.println("Before Suite method");
	}
	
	@BeforeTest
	public void SetDrivers() {
		System.out.println("Before Test method");
	}
	
	@BeforeClass
	public void setData() {
		System.out.println("Before Class method");
	}
	
	@BeforeMethod
	public void setTCS() {
		System.out.println("Before Method method");
	}
	
	@Test
	public void Testing() {
		System.out.println("Test case 1 method");
	}
	
	@Test
	public void Tesitng2() {
		System.out.println("Test case 2 method");
	}
	
	@AfterMethod
	public void closingTcS() {
		System.out.println("After method method");
	}
	
	@AfterClass
	public void closingData() {
		System.out.println("After class method");
	}
	
	@AfterTest
	public void closingDrivers() {
		System.out.println("After Test method");
	}
	
	@AfterSuite
	public void clearingCache() {
		System.out.println("After Suite method");
	}
	
	

}
