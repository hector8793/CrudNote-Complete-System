package com.crud.repository;

import java.util.List;

import com.crud.model.User;

public interface UserRepository{
	List<User> findAll();
	public User findOne(String Id);
	public User saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(String Id);
}