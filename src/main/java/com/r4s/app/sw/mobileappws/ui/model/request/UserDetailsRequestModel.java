package com.r4s.app.sw.mobileappws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDetailsRequestModel {
	
	@NotNull(message="First name cannot be null")
	@Size(min=2, message = "First name must not be less than 2 caracters")
	private String firstName;
	
	@NotNull(message="last name cannot be null")
	@Size(min=2, message = "Last name must not be less than 2 caracters")
	private String lastName;
	
	@NotNull(message="Email cannot be null")
	@Email
	private String email;
	
	@NotNull(message="Password cannot be null")
	@Size(min=8, max=16, message = "Password must equal or greater than 8 caracters and less than 16 caracters")
	private String password;
}
