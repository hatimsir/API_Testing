package com.API_Testing_Base;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {
	
	public static RequestSpecification httpsrequest;
	public static Response response;
	public static String responseBody;
	public static JsonPath jsonpath;
	
	public static JSONParser jsonparser;
	public static Object object;
	public static JSONObject apijasonobject;
	public static JSONArray array;
	
	public static String name;
	public static String description;
	
	public static JSONObject promotions;
	
	
	
	
	
	public static void init(){
		//Specify Base URI
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
				
		//This will create Request Object
		httpsrequest = RestAssured.given();
				
		//Response Object
		response = httpsrequest.request(Method.GET);
	}
	
	public static void printResponseOnConsole(){
		responseBody = response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
	}
	
	public static int getStatusCode(){
		int statusCode=response.getStatusCode();
		System.out.println("Status code in API response is: "+statusCode);
		return statusCode;
		
	}
	
	public static String getStatusLine(){
		String statusLine=response.getStatusLine();
		System.out.println("Status line in API response is:  "+statusLine);
		return statusLine;
		
	}
	
	public static void statusCodeValidation(int receivedstatuscode, int expectedStatusCode){
		
		
		if(receivedstatuscode==expectedStatusCode){
			Assert.assertTrue(true);
			System.out.println("Status code matched with expected value: "+expectedStatusCode);
			
		}
		else{
			System.out.println("Status code does NOT matched with expected value. Expected was " +expectedStatusCode+ " but received as : "+ receivedstatuscode);
			Assert.assertTrue(false);
		}
		
		
	}
	
public static void statusLineValidation(String receivedStatusLine, String expectedStatusLine){
		
		
		if(receivedStatusLine.equals(expectedStatusLine)){
			Assert.assertTrue(true);
			System.out.println("Status Line matched with expected value: "+expectedStatusLine);
		}
		else{
			System.out.println("Status Line does NOT matched with expected value. Expected was " +expectedStatusLine+ " but received as : "+ receivedStatusLine);
			Assert.assertTrue(false);
		}
		
		
	}

		public static String getHeadervalue(String headername){
		String headerValue = response.header(headername);
		System.out.println("Header value of "+headername+ " is: "+headerValue);
		return headerValue;
	
		}
		
		public static void verifyHeaderValue(String headervalue, String expectedHeaderValue){
		
		if(headervalue.equals(expectedHeaderValue)){
			Assert.assertTrue(true);
			System.out.println("Header value matched with expected value: "+expectedHeaderValue);
			}
			else{
			System.out.println("Header value do NOT matched with expected value. Expected was " +expectedHeaderValue+ " but received as : "+ headervalue);
			Assert.assertTrue(false);
			}
			
	
		}
		
		public static JsonPath extractEntireJSONPayloadNodes(){
			jsonpath = response.jsonPath();
			return jsonpath;
		
			}
		
		

		public static String extract_string_Node(String nodename){
			
			String nodevalue = jsonpath.get(nodename);
			System.out.println(nodename +" value in API is  "+ nodevalue);
			return nodevalue;
			}
		
		public static void verifyNodeValue(String receivednodevalue, String expectedNodeValue){
			
			if(receivednodevalue.equals(expectedNodeValue)){
				Assert.assertTrue(true);
				System.out.println("Node value matched with expected value: "+expectedNodeValue);
				}
				else{
				System.out.println("Node value do NOT matched with expected value. Expected was " +expectedNodeValue+ " But received as : "+ receivednodevalue);
				Assert.assertTrue(false);
				}
				
		
			}
		
		public static boolean extract_boolean_Node(String nodename){
			
			boolean nodevalue = jsonpath.get(nodename);
			System.out.println(nodename +" value in API is  "+ nodevalue);
			return nodevalue;
		}
		
		public static void verifyNodeValue_boolean(boolean receivednodevalue, boolean expectedNodeValue){
			
			if(receivednodevalue==expectedNodeValue){
				Assert.assertTrue(true);
				System.out.println("Node value matched with expected value: "+expectedNodeValue);
				}
				else{
				System.out.println("Node value do NOT matched with expected value. Expected was " +expectedNodeValue+ " But received as : "+ receivednodevalue);
				Assert.assertTrue(false);
				}
				
		
			}
	
	
	public static void extractChild_JSONPayload(String nameofnodetobeExtracted) throws ParseException{
		//creating object for JSONParser to parse JSON payload from API
		jsonparser =  new JSONParser();
				
		//Loading the JSON payload from API and storing in object of Object class
		object = jsonparser.parse(responseBody);
				
		//Converting or typecasting java object to JSON Object
		apijasonobject = (JSONObject)object;
				
		//Extracting child nodes of "Promotions" node and storing it in JSON array
		 array = (JSONArray)apijasonobject.get(nameofnodetobeExtracted);
	}
	
	public static void findElementsinJSONResponse(String childnode1, String childnode2){
		
		//Extracting sub elements "Name" and "Description" from each child nodes of "Promotions" node
		for (int i=0;i<array.size();i++){
			promotions = (JSONObject)array.get(i);
			name = (String)promotions.get(childnode1);
			description = (String)promotions.get(childnode2);
			
			//Printing Node number in console
			System.out.println("Promotions sub node number: "+ i+" "+ "is.....");
			//Printing value of sub elements "Name" and "Description" in console
			System.out.println("Name:  "+name);
			System.out.println("Description:  "+description);
			//If program finds a sub element "Name" with "Gallery" then break the for loop
			if (name.equals("Gallery"))
			break;
			System.out.println("**********************************************");
		}
	}
	
	public static void matchingDescriptionText(String expectedText){
		//Verifying sub element "Description" contains expected text or not
		if (description.contains(expectedText)){
		Assert.assertTrue(true);
		System.out.println("**********************************************");
		System.out.println("The Promotions element with Name = " + name + " has a Description that contains the text "+expectedText);
		}else{
		System.out.println("**********************************************");
		System.out.println("The Promotions element with Name = " + name + " do NOT have a Description that contains the text "+expectedText);
		Assert.assertTrue(false);
		}
	}
	
}