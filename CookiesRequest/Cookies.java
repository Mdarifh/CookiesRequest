package CookiesRequest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {

	// Cookies and headers
	
	@Test(priority=2)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		
		.then()
		//.cookie("ACE","AUEFqZdiC9eIrbgXsWxBTqrb4UMqXHYvYPK2uzYTcemp5Z_Z3xgeW1J3mlc; expires=Fri, 13-Oct-2023 05:54:04 GMT; path=/; domain=.google.com; Secure; HttpOnly; SameSite=lax")
		.log().all();
	}
	
	// Multiple Cookies info
	
	@Test(priority=3)
	void testCookiesInfo()
	{
		Response res = given()
		
		.when()
		.get("https://www.google.com/");
		
		// get Single Cookies info
		
		 String cookie_value1 = res.cookie("AEC");
		 System.out.println("The Value of cookies is====> "+cookie_value1);
		 
	}
	
	// get all cookies info
	
	@Test
	void testAllCookies()
	{
		Response res = given()
				
				.when()
				.get("https://www.google.com/");
		
		Map<String, String> cookies_values = res.getCookies();
		//System.out.println(cookie_values.keySet());
		
		
		for(String k : cookies_values.keySet()) {
			String cookie_values = res.getCookie(k);
			System.out.println(k+"    "+cookie_values);
		}
				
	}
}
