package com.API_Testing.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing.Base.Test_Base;


public class TC_2_verify_Status_Line extends Test_Base {
	
	@BeforeClass
	void TestCase_2_Start(){
		System.out.println("*****************Test Case 2 Starts**********************");
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Test_Base.init();
	}
	
	@Test
	void verifyStatusLine(){
	
		//getting Status Line from API response
		String statusline = Test_Base.getStatusLine();
		
		//Validating Status Line received from response is "HTTP/1.1 200 OK" or not. Passing actual status line received and expected status line as arguments
		Test_Base.statusLineValidation(statusline,"HTTP/1.1 200 OK");
		

}
	
	@AfterClass
	void TestCase_2_Ends(){
		System.out.println("*****************Test Case 2 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
}
