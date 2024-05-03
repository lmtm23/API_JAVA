package com.unosquare;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;




public class Post {
	
	
	
	  
	  @Test
	  public void http_Post1() {
		  
		  try {
			  JSONParser json = new JSONParser();
			  FileReader reader = new FileReader("C:\\Users\\luis.toscano\\eclipse-workspace\\javaAPI\\src\\test\\java\\com\\unosquare\\json\\Register.json");
			  Object obj = json.parse(reader);
			  
			  RestAssured.baseURI = "https://reqres.in/api"; 
				 RequestSpecification httpRequest = RestAssured.given(); 
				 httpRequest.headers("Content-Type", "application/json");
				 httpRequest.body(obj.toString());
				 Response response = httpRequest.post("/register");
				 
				 int statusCode = response.getStatusCode();				 
				 Assert.assertEquals(statusCode, 200);
				 response.then().body("id", equalTo(4));
				 response.then().body("token", equalTo("QpwL5tke4Pnpja7X4"));				
				 Reporter.log("URL:"+ RestAssured.baseURI);	
				 Reporter.log("Status code:"+statusCode);
				 Reporter.log("JsonBody:"+obj);
				 Reporter.log("Response:"+response.body().asString());
			  
		  }catch(IOException | ParseException e) {
			  e.printStackTrace();
		  }
	  }
	  
	  
	  
	  
	  @Test
	  public void http_Post2() {
		  
		  try {
			  JSONParser json = new JSONParser();
			  FileReader reader = new FileReader("C:\\Users\\luis.toscano\\eclipse-workspace\\javaAPI\\src\\test\\java\\com\\unosquare\\json\\login.json");
			  Object obj = json.parse(reader);
			  
			  RestAssured.baseURI = "https://reqres.in/api"; 
				 RequestSpecification httpRequest = RestAssured.given(); 
				 httpRequest.headers("Content-Type", "application/json");
				 httpRequest.body(obj.toString());
				 Response response = httpRequest.post("/login");
				 
				 int statusCode = response.getStatusCode();				 
				 Assert.assertEquals(statusCode, 200);
				 response.then().body("token", equalTo("QpwL5tke4Pnpja7X4"));
				 Reporter.log("URL:"+ RestAssured.baseURI);	
				 Reporter.log("Status code:"+statusCode);
				 Reporter.log("JsonBody:"+obj);
				 Reporter.log("Response:"+response.body().asString());
			  
		  }catch(IOException | ParseException e) {
			  e.printStackTrace();
		  }
	  }
  @Test
  public void f() {
	  
	  try {
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader("C:\\Users\\luis.toscano\\eclipse-workspace\\javaAPI\\src\\test\\java\\com\\unosquare\\json\\Register.json");
	  Object obj = json.parse(reader);
	  
	  given()
		  .contentType("application/json")  //another way to specify content type
	      .body(obj.toString())
	  .when()
	  	.post("https://reqres.in/api/register")
	  .then()
	  	.assertThat().statusCode(200)
	  	.assertThat().contentType(ContentType.JSON)
	  	.assertThat().body("id", equalTo(4))
	  	.assertThat().body("token", equalTo("QpwL5tke4Pnpja7X4"));
	  Reporter.log("Success 200 validation");
	  	
	  	 
	  
	  }catch(IOException | ParseException e) {
		  e.printStackTrace();
	  }
	
	  
  }

}
