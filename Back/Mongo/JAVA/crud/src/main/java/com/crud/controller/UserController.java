package com.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.User;
import com.crud.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	private UserRepository userRepository;
	private User user;


	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@RequestMapping(value="/{userId}",method = RequestMethod.GET)
	public ResponseEntity<User> userById(@PathVariable String Id){
		user = userRepository.findOne(Id);
		return ResponseEntity.ok(user);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(userRepository.findAll());
	}


	@RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable String userId){
		userRepository.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}


	@RequestMapping(method=RequestMethod.POST)
	public  ResponseEntity<User> saveUser(@RequestBody @Valid User user){
		return ResponseEntity.ok(userRepository.saveUser(user));
	}
}
