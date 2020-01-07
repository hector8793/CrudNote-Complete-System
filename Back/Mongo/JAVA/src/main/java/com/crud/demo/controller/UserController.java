package com.crud.demo.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.models.User;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user")
public class UserController {
	
	
	private UserService userRepository;
	private User user;
	
	@Autowired
	public UserController(UserService userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> userById(@PathVariable String id){
		user = userRepository.findOne(id);
		return ResponseEntity.ok(user);
		//return id;
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
	
	@RequestMapping(method=RequestMethod.PUT)
	public  ResponseEntity<User> updateUser(@RequestBody @Valid User user){
		userRepository.updateUser(user);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("health")
	public String health(){
		return "health ok!";
	}
}
