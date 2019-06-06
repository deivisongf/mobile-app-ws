package com.r4s.app.sw.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r4s.app.sw.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.r4s.app.sw.mobileappws.ui.model.response.UserDetailsResponseModel;
import com.r4s.app.sw.shared.Utils;
import com.r4s.app.sw.userservice.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	Map<String, UserDetailsResponseModel> users;
	Utils utils;
	
	public UserServiceImpl() {}
	
	@Autowired
	public UserServiceImpl(Utils utils) {
		this.utils = utils;
	}
	
	@Override
	public UserDetailsResponseModel createUser(UserDetailsRequestModel userDetails) {
		
		UserDetailsResponseModel fakeUser = new UserDetailsResponseModel();
		fakeUser.setEmail(userDetails.getEmail());
		fakeUser.setFirstName(userDetails.getFirstName());
		fakeUser.setLastName(userDetails.getLastName());
		fakeUser.setPassword(userDetails.getPassword());
		
		String userId = utils.generateUserId();
		fakeUser.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, fakeUser);
		
		return fakeUser;
	}
}
