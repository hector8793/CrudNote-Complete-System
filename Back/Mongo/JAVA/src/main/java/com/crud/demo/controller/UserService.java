package com.crud.demo.controller;

import java.util.List;

import com.crud.demo.models.User;

public interface UserService{
	public List<User> findAll();
	public User findOne(String Id);
	public User saveUser(User user);
	public void updateUser(User user);
	public int deleteUser(String Id);
}