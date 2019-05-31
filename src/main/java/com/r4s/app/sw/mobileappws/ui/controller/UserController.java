package com.r4s.app.sw.mobileappws.ui.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r4s.app.sw.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.r4s.app.sw.mobileappws.ui.model.response.UserDetailsResponseModel;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
	
	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, 
						  @RequestParam(value="limit", defaultValue="50") int limit,
						  @RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		
		return "get user was called with page " + page + " and limit " + limit + " and sort " + sort;
	}
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetailsResponseModel> getUser(@PathVariable String userId) {
		
		UserDetailsResponseModel fakeUser = new UserDetailsResponseModel();
		fakeUser.setEmail("testing@test.com");
		fakeUser.setFirstName("Deiv");
		fakeUser.setLastName("Guar");
		
		return new ResponseEntity<UserDetailsResponseModel>(fakeUser, HttpStatus.OK);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
				 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetailsResponseModel> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserDetailsResponseModel fakeUser = new UserDetailsResponseModel();
		fakeUser.setEmail(userDetails.getEmail());
		fakeUser.setFirstName(userDetails.getFirstName());
		fakeUser.setLastName(userDetails.getLastName());
		fakeUser.setPassword(userDetails.getPassword());
		
		return new ResponseEntity<UserDetailsResponseModel>(fakeUser, HttpStatus.OK);
	}
	
	@PutMapping
	public String updateUser() {
		return "update user was called";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
