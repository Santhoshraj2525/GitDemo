package com.testNGPackage;

import org.testng.annotations.Test;

public class InvocationDemo {
	
	@Test (invocationCount=3)
	public void hello() {
		System.out.println("Heloo");
		
	}

	@Test (expectedExceptions=NumberFormatException.class)
	public void he() {
		String s="120K";
		Integer.parseInt(s);
	}
}
