package com.api.base;
import java.util.HashMap;

import com.api.models.request.LoginRequests;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	private static final String BASE_Path ="/api/auth/";
	
	public Response login(LoginRequests payload) {
		
		return postRequest(payload, BASE_Path + "login");
		
		
	}
	
	public Response signup(SignUpRequest payload) {
		
		return postRequest(payload, BASE_Path + "signup");
		
		
	}
	
	public Response forgetPassword(String emailAddress) {
		HashMap<String, String > payload = new HashMap<String, String>();
		payload.put("email", emailAddress);
		
		return postRequest(payload, BASE_Path + "forgot-password");
	}
	

}
