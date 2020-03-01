package com.API_Testing.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing.Base.Test_Base;


public class TC_3_verify_Headers extends Test_Base {
	
	@BeforeClass
	void TestCase_3_Start(){
		System.out.println("*****************Test Case 3 Starts**********************");
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Test_Base.init();
	}

	@Test
	void verifyHeaders(){
		
	//Validation of important Headers from response
		
	
	String header_contentType_value = Test_Base.getHeadervalue("content-type"); //Get header "content-type"
	Test_Base.verifyHeaderValue(header_contentType_value, "application/json"); //Validate headers value as expected or not. Passing actual value and expected value as arguments
	
	
	String header_contentEncoding_value = Test_Base.getHeadervalue("content-encoding");
	Test_Base.verifyHeaderValue(header_contentEncoding_value, "gzip");
	
	
	String header_vary_value = Test_Base.getHeadervalue("vary");
	Test_Base.verifyHeaderValue(header_vary_value, "Accept-Encoding"); 
		
		
	}
	
	@AfterClass
	void TestCase_3_Ends(){
		System.out.println("*****************Test Case 3 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}

}
