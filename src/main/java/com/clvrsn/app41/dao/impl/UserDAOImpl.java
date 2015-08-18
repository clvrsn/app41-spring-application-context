package com.clvrsn.app41.dao.impl;

import com.clvrsn.app41.dao.UserDAO;
import com.clvrsn.app41.entities.User;

public class UserDAOImpl implements UserDAO {

	private User userExample;

	public User findById(Integer id) {
		return userExample;
	}

	public User getUserExample() {
		return userExample;
	}

	public void setUserExample(User userExample) {
		this.userExample = userExample;
	}
}
