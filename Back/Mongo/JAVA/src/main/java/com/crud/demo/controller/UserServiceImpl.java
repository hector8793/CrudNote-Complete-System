package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.crud.demo.models.User;


@Repository
public class  UserServiceImpl implements UserService{

	MongoTemplate mongoTemplate;
	public String COLLECTION = "users";
	
    @Autowired
    public UserServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
	public List<User> findAll() {
		 return mongoTemplate.findAll(User.class,
				    COLLECTION);
	}    

    @Override
	public User findOne(String id) {
		return mongoTemplate.findById(id, User.class,COLLECTION);
	}

    @Override
	public User saveUser(User user) {
		this.mongoTemplate.insert(user,COLLECTION);
		return user;
	}

    @Override
	public void updateUser(User user) {
		this.mongoTemplate.save(user,COLLECTION);
	}

    @Override
	public int deleteUser(String id) {
		  Query query = new Query(Criteria.where("_id").is(id));
		  this.mongoTemplate.findAndRemove(query, User.class,
		    COLLECTION);
		  return 1;
	}

}
