package com.course.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.dtos.PostDTO;
import com.course.workshopmongo.resources.utils.URL;
import com.course.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(new PostDTO(post));
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") 
			String text) {
		
		text = URL.decodeParam(text);
		List<Post> posts = service.findByTitle(text);
		List<PostDTO> postsDtos = posts.stream().map(x -> new PostDTO(x)).toList();
		
		return ResponseEntity.ok().body(postsDtos);
	}
	
}
