package com.API_Testing.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing_Base.Base;


public class TC_5_verify_node_CanRelist extends Base {
	
	@BeforeClass
	void TestCase_5_Start(){
		System.out.println("*****************Test Case 5 Starts**********************");
	}
	

	@Test
	void verifyAcceptanceCriteria_CanRelist(){
		
		//init method createdin Base class to navigate to base URI and hit API request and get a response
		Base.init();
			
		//This will return JsonPath Object. This object will be used to further query specific parts of the Response Json
		jsonpath = Base.extractEntireJSONPayloadNodes();
		
		//This will extract individual node values
		boolean canrelist = Base.extract_boolean_Node("CanRelist");
		
		//This will validate boolean node value received from response with expected value. Passing actual node value received and expected value as arguments
		Base.verifyNodeValue_boolean(canrelist, true);
			
		}	
	
	@AfterClass
	void TestCase_5_Ends(){
		System.out.println("*****************Test Case 5 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}

}
	

