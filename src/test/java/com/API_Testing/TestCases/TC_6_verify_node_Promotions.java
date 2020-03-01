package com.API_Testing.TestCases;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing_Base.Base;


public class TC_6_verify_node_Promotions extends Base {
	
	@BeforeClass
	void TestCase_6_Start(){
		System.out.println("*****************Test Case 6 Starts**********************");
	}
	
	
	@Test
	void verifyAcceptanceCriteria_Promotions() throws ParseException{
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Base.init();
				
		//Extracting JSON response using JSONParser
		Base.extractChild_JSONPayload("Promotions");
		
		//Extracting sub elements "Name" and "Description" from each child nodes of "Promotions" node
		Base.findElementsinJSONResponse("Name", "Description");
		
		//Verifying sub element "Description" contains expected text or not
		Base.matchingDescriptionText("2x larger image");
}
	
	@AfterClass
	void TestCase_6_Ends(){
		System.out.println("*****************Test Case 6 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
	
}
