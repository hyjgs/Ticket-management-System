package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.User;

public interface UserDao {
	List<User> getUserByID(User user);
	List<User> getUserByName(User user);
	List<User> getUserByRoleName(User user);
	boolean removeUser(User user);
	User getUser2(User user);
	
}
