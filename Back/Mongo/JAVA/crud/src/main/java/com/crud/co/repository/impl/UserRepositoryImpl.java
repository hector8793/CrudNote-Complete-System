package com.crud.co.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.crud.co.model.User;
import com.crud.co.repository.UserRepository;
import com.mongodb.WriteResult;

public class  UserRepositoryImpl implements UserRepository{

	//@Autowired
	//private final MongoOperations mongoOperations;
	private static final String COLLECTION = "user";
	
	MongoTemplate mongoTemplate;


	public List findAll() {
		 return (List) mongoTemplate.findAll(User.class,
				    COLLECTION);
	}    

	public User findOne(String id) {
		  Query query = new Query(Criteria.where("_id").is(id));
		  return this.mongoTemplate.findOne(query, User.class, COLLECTION);
	}


	public User saveUser(User user) {
		this.mongoTemplate.insert(user,COLLECTION);
		return user;
	}


	public void updateUser(User user) {
		this.mongoTemplate.save(user,COLLECTION);
	}


	public int deleteUser(String id) {
		  Query query = new Query(Criteria.where("_id").is(id));
		  this.mongoTemplate.findAndRemove(query, User.class,
		    COLLECTION);
		  return 1;
	}

}
