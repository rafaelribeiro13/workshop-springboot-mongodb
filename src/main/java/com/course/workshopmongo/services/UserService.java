package com.course.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.repositories.UserRepository;
import com.course.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> optionalUser = repository.findById(id);
		return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Object not found, Id = " + id));
	}
	
}
