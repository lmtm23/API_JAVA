package com.unosquare;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.text.ParseException;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class ResponsePostLogin {
	ApiCore apicore;
  @Test
  public void postLogin() throws IOException, ParseException {
	  
	  Response test= apicore.postLogin("C:\\\\Users\\\\luis.toscano\\\\eclipse-workspace\\\\javaAPI\\\\src\\\\test\\\\java\\\\com\\\\unosquare\\\\json\\\\Register.json", "/login");
		 				 
		 Assert.assertEquals(200, test.statusCode());
		 test.then().body("token", equalTo("QpwL5tke4Pnpja7X4"));
		 Reporter.log("Response:"+test.body().asString());
  }
  @BeforeSuite
  public void beforeSuite() {
	  apicore = new ApiCore();
  }

}
