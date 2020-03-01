package com.API_Testing.TestCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.API_Testing.Base.Test_Base;


public class TC_4_verify_node_Name extends Test_Base {
	
	@BeforeClass
	void TestCase_4_Start() throws IOException{
		System.out.println("*****************Test Case 4 Starts**********************");
		
		//init method created in Base class to navigate to base URI and hit API request and get a response
		Test_Base.init();
	}
	

	@Test
	void verifyAcceptanceCriteria_Name(){
		
		//This will return JsonPath Object. This object will be used to further query specific parts of the Response Json
		jsonpath = Test_Base.extractEntireJSONPayloadNodes();
	
		
		//This will extract individual node values
		String node_value = Test_Base.extract_string_Node("Name");
		
		//This will validate node value received from response with expected value. Passing actual node value received and expected value as arguments
		Test_Base.verifyNodeValue(node_value, "Carbon credits");
		
			
		}
		
		
	@AfterClass
	void TestCase_4_Ends(){
		System.out.println("*****************Test Case 4 Ends**********************");
		System.out.println("--------------------------------------------------------------------------------------\n");
	}
}
	

