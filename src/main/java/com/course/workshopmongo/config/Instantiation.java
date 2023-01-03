package com.course.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.course.workshopmongo.domain.Post;
import com.course.workshopmongo.domain.User;
import com.course.workshopmongo.dtos.AuthorDTO;
import com.course.workshopmongo.repositories.PostRepository;
import com.course.workshopmongo.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com");
		User u2 = new User(null, "Alex Green", "alex@gmail.com");
		User u3 = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));

		Post post1 = new Post(null, Instant.parse("2023-01-03T15:30:05Z")
				, "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
		Post post2 = new Post(null, Instant.parse("2023-01-03T19:50:30Z")
				, "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		u1.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(u1);
		
	}

}
