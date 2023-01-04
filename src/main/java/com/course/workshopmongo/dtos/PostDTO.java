package com.course.workshopmongo.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.course.workshopmongo.domain.Post;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private Instant date;
	private String title;
	private String body;
	private AuthorDTO author;
	
	public PostDTO() {
	}
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.date = post.getDate();
		this.title = post.getTitle();
		this.body = post.getBody();
		this.author = post.getAuthor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public AuthorDTO getAuthor() {
		return author;
	}
	
}
