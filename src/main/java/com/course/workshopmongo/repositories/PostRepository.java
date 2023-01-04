package com.course.workshopmongo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.course.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query(value = "{ title: { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);
	
}