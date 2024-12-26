package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

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
	
}
