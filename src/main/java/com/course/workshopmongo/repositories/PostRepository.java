package com.course.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.course.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}