package com.crud.co.repository;

import java.util.List;

import com.crud.co.model.User;

public interface UserRepository{
	public List findAll();
	public User findOne(String Id);
	public User saveUser(User user);
	public void updateUser(User user);
	public int deleteUser(String Id);
}