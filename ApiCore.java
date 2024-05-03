package com.unosquare;

import static org.hamcrest.Matchers.equalTo;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiCore {
	
  
  public Response postLogin(String jsonPath, String postRequest) {
	  
	  Response response = null;
	  try {
		  JSONParser json = new JSONParser();
		  FileReader reader = new FileReader(jsonPath);
		  Object obj = json.parse(reader);
		  
		  RestAssured.baseURI = "https://reqres.in/api"; 
			 RequestSpecification httpRequest = RestAssured.given(); 
			 httpRequest.headers("Content-Type", "application/json");
			 httpRequest.body(obj.toString());
			 response = httpRequest.post(postRequest);
			 
				/*
				 * int statusCode = response.getStatusCode(); Assert.assertEquals(statusCode,
				 * 200); response.then().body("token", equalTo("QpwL5tke4Pnpja7X4"));
				 * Reporter.log("URL:"+ RestAssured.baseURI);
				 * Reporter.log("Status code:"+statusCode); Reporter.log("JsonBody:"+obj);
				 * Reporter.log("Response:"+response.body().asString());
				 */
		  
	  }catch(IOException | ParseException e) {
		  e.printStackTrace();
	  }
	return response;
	  
  }
  
}
