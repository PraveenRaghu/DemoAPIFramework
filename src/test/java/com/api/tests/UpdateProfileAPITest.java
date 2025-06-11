package com.api.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagmentService;
import com.api.models.request.LoginRequests;
import com.api.models.request.UpdateRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileAPITest {
	
	@Test
	public void updateProfile() {
		
		AuthService authService = new AuthService();
		Response response =authService.login(new LoginRequests("Praveen","prav1234"));
		System.out.println(response.asPrettyString());
		String token =response.as(LoginResponse.class).getToken();
		
		System.out.println("----------------------------------------");
		
		UserManagmentService userMangmentService = new UserManagmentService();
		response =userMangmentService.getProfile(token);
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		String userProfile=userProfileResponse.getUsername();
		Assert.assertEquals(userProfile,"Praveen" );
		
		System.out.println("----------------------------------------");
		
		UpdateRequest updateRequest = new UpdateRequest.Builder()
				.firstName("Praveen")
				.lastName("Raghuvanshi")
				.email("prav@test.com")
				.mobileNumber("7777777778")
				.build();
		response =userMangmentService.updateProfile(updateRequest, token);
		System.out.println(response.asPrettyString());
		
		
		
		
	}

}
