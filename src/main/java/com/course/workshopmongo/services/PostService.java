package com.course.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.repositories.PostRepository;
import com.course.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> optionalPost = repository.findById(id);
		return optionalPost.orElseThrow(() -> 
			new ObjectNotFoundException("Object not found, Id = " + id));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(text, minDate.toInstant(), maxDate.toInstant());
	}
	
}
