package com.ansh.test.dao;

import java.util.List;

public interface UserDao {
	public List<String> getAllUsers();
	
	public String getCityByZipCode(String zipCode);
}
