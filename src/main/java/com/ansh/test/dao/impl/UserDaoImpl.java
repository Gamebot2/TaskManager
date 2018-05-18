package com.ansh.test.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ansh.test.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<String> getAllUsers() {
		return Arrays.asList("Rex", "Pyra", "Nia", "Dromarch", "Tora", "Poppi", "Morag", "Brighid", "Zeke", "Pandoria");
	}

	@Override
	@Cacheable("zipCodeCityMappingCache")
	public String getCityByZipCode(String zipCode) {
		System.out.println("Invoked for zipcode " + zipCode);
		return "Frisco`";
	}
	
	@CachePut("zipCodeCityMappingCache")
	public String updateCityByZipCode(String zipCode) {
		System.out.println("Invoked for zipcode " + zipCode);
		return "Frisco`";
	}
	
	@CacheEvict("zipCodeCityMappingCache")
	public String deleteCityByZipCode(String zipCode) {
		System.out.println("Invoked for zipcode " + zipCode);
		return "Frisco`";
	}
	
	
}
