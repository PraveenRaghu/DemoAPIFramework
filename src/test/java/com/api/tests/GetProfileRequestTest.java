package com.api.tests;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagmentService;
import com.api.models.request.LoginRequests;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	@Test
	public void getProfileTest() {
		
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequests("Praveen","prav1234"));
		String token =response.as(LoginResponse.class).getToken();
		
		UserManagmentService userManagmentService = new UserManagmentService();
		response=userManagmentService.getProfile(token);
		System.out.println(response.asPrettyString());
		String userName=response.as(UserProfileResponse.class).getFirstName();
		System.out.println(userName);
		
	}

}
