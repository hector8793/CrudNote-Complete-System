package com.crud.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.crud.model.User;
import com.crud.repository.UserRepository;

public class  UserRepositoryImpl implements UserRepository{

	@Autowired
	private final MongoOperations mongoOperations;

	public UserRepositoryImpl(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}


	public List<User> findAll() {
		List<User> users = this.mongoOperations.find(new Query(), User.class);
		List<User> optionalUsers = users;
		return optionalUsers;
	}    

	public User findOne(String Id) {
		User d = this.mongoOperations.findOne(new Query(Criteria.where("userId").is(Id)), User.class);
		User user = d;
		return user;
	}


	public User saveUser(User user) {
		this.mongoOperations.save(user);
		return user;
	}


	public void updateUser(User user) {
		this.mongoOperations.save(user);
	}


	public void deleteUser(String userId) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("userId").is(userId)), User.class);
	}

}
