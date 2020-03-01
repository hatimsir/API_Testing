package com.API_Testing.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing.Base.Test_Base;


public class TC_5_verify_node_CanRelist extends Test_Base {
	
	@BeforeClass
	void TestCase_5_Start() throws IOException{
		System.out.println("*****************Test Case 5 Starts**********************");
		
		//init method createdin Base class to navigate to base URI and hit API request and get a response
		Test_Base.init();
	}
	

	@Test
	void verifyAcceptanceCriteria_CanRelist(){
	
		//This will return JsonPath Object. This object will be used to further query specific parts of the Response Json
		jsonpath = Test_Base.extractEntireJSONPayloadNodes();
		
		//This will extract individual node values
		boolean canrelist = Test_Base.extract_boolean_Node("CanRelist");
		
		//This will validate boolean node value received from response with expected value. Passing actual node value received and expected value as arguments
		Test_Base.verifyNodeValue_boolean(canrelist, true);
			
		}	
	
	@AfterClass
	void TestCase_5_Ends(){
		System.out.println("*****************Test Case 5 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}

}
	

