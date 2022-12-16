package com.filter.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filter.beans.User;
import com.filter.repository.UserRepository;
import com.filter.service.UserService;


/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService<User> {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UserRepository<User> userRepo;
	
	public UserServiceImpl() {}

	public User create(User element) {
		logger.info("-------------- Added user ------------------", element.toString());
		return (User) userRepo.save(element);
	}

	public User update(User data, String id) {
		return (User) userRepo.save(data);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public List<User> getByFirstname(String firstname) {
		return userRepo.findAll().stream().filter(x -> x.getFirstname().equals(firstname)).collect(Collectors.toList());
	}

	@Override
	public List<User> getByLastname(String lastname) {
		return userRepo.findAll().stream().filter(x -> x.getFirstname().equals(lastname)).collect(Collectors.toList());
	}
	
	@Override
	public List<User> getByFirstnameLastname(String firstname, String lastname) {
		return userRepo.findAll().stream().filter(x -> x.getFirstname().equals(firstname))
				.filter(x -> x.getFirstname().equals(lastname))
				.collect(Collectors.toList());
	}

	@Override
	public List<User> getByAge(int age) {
		return userRepo.findAll().stream().filter(x -> x.getAge() == age).collect(Collectors.toList());

	}
	
	@Override
	public List<User> getByWeight(double weight) {
		return userRepo.findAll().stream().filter(x -> x.getWeight() == weight).collect(Collectors.toList());
	}
	
	@Override
	public List<User> getByAgeAndWeight(int age, double weight){
		return userRepo.findAll().stream().filter(x -> x.getAge() == age).filter(x -> x.getWeight() == weight)
				.collect(Collectors.toList());
	}

	@Override
	public List<User> getBySsn(String ssn) {
		return userRepo.findAll().stream().filter(x -> x.getSsn().equals(ssn)).collect(Collectors.toList());

	}
	
	@Override
	public int countRows() {
		return userRepo.countRows();
	}

	
}
