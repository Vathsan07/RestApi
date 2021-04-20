package com.spring5learningtest.restapi.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring5learningtest.restapi.model.UserDetails;
import com.spring5learningtest.restapi.requestmodel.RequestUserDetails;

@RestController
@RequestMapping("/users")
public class RestApiController {

	@GetMapping(path = "/{userid}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					})
	public UserDetails getUser(@PathVariable String userid) {
		UserDetails ud = new UserDetails();
		ud.setFirstName("Shri");
		ud.setAge(25);
		ud.setMail("Vathsan@gmail.com");
		return ud;
	}
	
/*	@GetMapping(path = "/{useri}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<UserDetails> getUser1(@PathVariable String useri) {
		UserDetails ud = new UserDetails();
		ud.setFirstName("Shri");
		ud.setAge(25);
		ud.setMail("Vathsan@gmail.com");
		return new ResponseEntity<UserDetails>(HttpStatus.BAD_REQUEST);
	}
*/	
	@GetMapping
	public String getUsers(@RequestParam(value="page") String page,
			@RequestParam(value="limit",defaultValue = "0") int limit,
			@RequestParam(value="sort",required = false)String sort) 
	{		
		return "Users : " + page+limit+sort;
	}

	@PostMapping(path = "/createuser",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserDetails> createUsers(@Valid @RequestBody RequestUserDetails req) 
	{
		UserDetails ud = new UserDetails();
		ud.setFirstName(req.getFirstName());
		ud.setAge(req.getAge());
		ud.setMail(req.getMail());
		return new ResponseEntity<UserDetails>(ud,HttpStatus.OK);
	}

	@PutMapping("/upduser")
	public String updateUsers() {
		return "Update Users";
	}

	@DeleteMapping("/deluser")
	public String deleteUsers() {
		return "Delete Users";
	}
}
