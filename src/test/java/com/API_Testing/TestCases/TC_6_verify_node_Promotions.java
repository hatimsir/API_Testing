package com.API_Testing.TestCases;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing.Base.Test_Base;


public class TC_6_verify_node_Promotions extends Test_Base {
	
	@BeforeClass
	void TestCase_6_Start() throws IOException{
		System.out.println("*****************Test Case 6 Starts**********************");
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Test_Base.init();
	}
	
	
	@Test
	void verifyAcceptanceCriteria_Promotions() throws ParseException{
				
		//Extracting JSON response using JSONParser
		Test_Base.extractChild_JSONPayload("Promotions");
		
		//Extracting sub elements "Name" and "Description" from each child nodes of "Promotions" node
		Test_Base.findElementsinJSONResponse("Name", "Description");
		
		//Verifying sub element "Description" contains expected text or not
		Test_Base.matchingDescriptionText("2x larger image");
}
	
	@AfterClass
	void TestCase_6_Ends(){
		System.out.println("*****************Test Case 6 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
	
}
