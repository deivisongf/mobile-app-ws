package com.r4s.app.sw.mobileappws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

import com.r4s.app.sw.mobileappws.ui.model.request.UpdateUserDetailRequestModel;
import com.r4s.app.sw.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.r4s.app.sw.mobileappws.ui.model.response.UserDetailsResponseModel;

@RestController
@RequestMapping("users") //http:localhost:8080/users
public class UserController {
	
	Map<String, UserDetailsResponseModel> users;
	
	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, 
						  @RequestParam(value="limit", defaultValue="50") int limit,
						  @RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		
		return "get user was called with page " + page + " and limit " + limit + " and sort " + sort;
	}
	
	@GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetailsResponseModel> getUser(@PathVariable String userId) {
		
		if(users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
				 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDetailsResponseModel> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		
		UserDetailsResponseModel fakeUser = new UserDetailsResponseModel();
		fakeUser.setEmail(userDetails.getEmail());
		fakeUser.setFirstName(userDetails.getFirstName());
		fakeUser.setLastName(userDetails.getLastName());
		fakeUser.setPassword(userDetails.getPassword());
		
		String userId = UUID.randomUUID().toString();
		
		fakeUser.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, fakeUser);
		
		return new ResponseEntity<UserDetailsResponseModel>(fakeUser, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
								  produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserDetailsResponseModel updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailRequestModel userDetails) {
		
		UserDetailsResponseModel storedUserDetails = users.get(userId);
		
		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());
		
		users.put(userId, storedUserDetails);
		
		return storedUserDetails;
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
}
