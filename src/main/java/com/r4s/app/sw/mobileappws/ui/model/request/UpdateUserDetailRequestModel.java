package com.r4s.app.sw.mobileappws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UpdateUserDetailRequestModel {
	
	@NotNull(message="First name cannot be null")
	@Size(min=2, message = "First name must not be less than 2 caracters")
	private String firstName;
	
	@NotNull(message="last name cannot be null")
	@Size(min=2, message = "Last name must not be less than 2 caracters")
	private String lastName;
}
