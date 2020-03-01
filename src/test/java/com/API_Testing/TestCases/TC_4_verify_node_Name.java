package com.API_Testing.TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing_Base.Base;


public class TC_4_verify_node_Name extends Base {
	
	@BeforeClass
	void TestCase_4_Start(){
		System.out.println("*****************Test Case 4 Starts**********************");
	}
	

	@Test
	void verifyAcceptanceCriteria_Name(){
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Base.init();
		
		//This will return JsonPath Object. This object will be used to further query specific parts of the Response Json
		jsonpath = Base.extractEntireJSONPayloadNodes();
	
		
		//This will extract individual node values
		String node_value = Base.extract_string_Node("Name");
		
		//This will validate node value received from response with expected value. Passing actual node value received and expected value as arguments
		Base.verifyNodeValue(node_value, "Carbon credits");
		
			
		}
		
		
	@AfterClass
	void TestCase_4_Ends(){
		System.out.println("*****************Test Case 4 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
}
	

