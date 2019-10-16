package com.testNGPackage;

import org.testng.annotations.Test;

public class TestNGFeatures {

	@Test
	public void login(){
		System.out.println("Logged in");
		int i=9/0;
	}
	
	@Test(dependsOnMethods="login")
	public void HomePage() {
		System.out.println("Home Page is openend");
	}
}
