package com.dyl.domain;

import java.util.List;

public class Blog {

	private Integer id;
	private String title;
	private Author author;
	private Integer status;
	private List<Post> posts;
	
	public Blog() {}
	public Blog(Integer id, String title, Author author, Integer status,List<Post> posts) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.status = status;
		this.posts = posts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", author=" + author + ", status=" + status + ", posts=" + posts
				+ "]";
	}
	
}
