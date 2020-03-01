package com.API_Testing.TestCases;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing_Base.Base;


public class TC_1_verify_Status_Code extends Base {
	
	@BeforeClass
	
	
	void TestCase_1_Start() {
		
		System.out.println("*****************Test Case 1 Starts**********************");
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Base.init();
	}
	
	
	@Test
	void verifyStatusCode(){
		
		//Print Response in console
		Base.printResponseOnConsole();
		
		 //getting status code from API response
		int statusCode = Base.getStatusCode();
		
		//Validating status code received from response is 200 or not. Passing actual status code received and expected value as arguments
		Base.statusCodeValidation(statusCode, 200);
		
	}
	
	@AfterClass
	void TestCase_1_Ends(){
		System.out.println("*****************Test Case 1 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}

}
