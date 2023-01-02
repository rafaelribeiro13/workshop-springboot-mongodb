package com.course.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User u1 = new User("1", "Maria Silva", "maria.silva@gmail.com");
		User u2 = new User("2", "Clara Dias", "clara.dias@gmail.com");
		
		return ResponseEntity.ok().body(Arrays.asList(u1, u2));
	}
	
}
