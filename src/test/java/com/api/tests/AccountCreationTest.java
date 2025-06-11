package com.api.tests;


import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description ="Verify SignUp")
	public void createAccountTest() {
		
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
				.username("raj1234")
				.firstName("Rajesh")
				.lastName("sahu")
				.email("raj1234@test.com")
				.mobileNumber("8888888889")
				.password("raj1234")
				.Build();
		
		AuthService authService = new AuthService();
		Response response=authService.signup(signUpRequest);
		
		System.out.println(response.asPrettyString());
		
	}
}
