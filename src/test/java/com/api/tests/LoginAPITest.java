package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequests;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.api.listeners.TestListeners.class)
public class LoginAPITest {
	
	@Test(description ="Verify API")
	public void loginTest() {
		LoginRequests loginrequest = new LoginRequests("Praveen","prav1234");
		AuthService authService = new AuthService();
		Response response=authService.login(loginrequest);
		LoginResponse loginResponse =response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
	
		
		//Response response=given().baseUri("http://64.227.160.186:8080").header("Content-Type","application/json").body("{\"username\": \"Praveen\",\"password\": \"prav1234\"}").post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	
	}

}
