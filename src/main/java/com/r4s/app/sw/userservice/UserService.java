package com.r4s.app.sw.userservice;

import com.r4s.app.sw.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.r4s.app.sw.mobileappws.ui.model.response.UserDetailsResponseModel;

public interface UserService {
	
	UserDetailsResponseModel createUser(UserDetailsRequestModel userDetails);
}
