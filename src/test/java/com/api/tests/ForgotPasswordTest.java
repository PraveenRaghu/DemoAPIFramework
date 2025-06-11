package com.api.tests;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description ="Verify ForgetPassword API")
	public void forgetPassword() {
		AuthService authService =new AuthService();
		Response response =authService.forgetPassword("raj1234@test.com");
		System.out.println(response.asPrettyString());
		
	}

}
