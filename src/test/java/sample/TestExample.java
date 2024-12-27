package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestExample {

	@Test
	public void test_1() {
		
		// API Store into response 
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		// Print Some Value from API
		System.out.println("API Status Code : "+response.getStatusCode());
		System.out.println("API GET Time "+response.getTime());
		System.out.println("API Body"+response.getBody().asString());
		System.out.println("API Status LIne : "+response.statusLine());
		System.out.println("API Header "+ response.getHeader("content-type"));
		
		// Check with Assert 
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		
	}
	
	
	@Test
	public void test_2() {
		
		// Using Static Imports
		baseURI="https://reqres.in/api"; // store API
		
		given().get("/users?page=2")  // call specific 
		.then().
			statusCode(200).			// check status Code
		body("data[3].id",equalTo(10))  // validate ID Value
			.log().all();				// Print All Json format in Console
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
