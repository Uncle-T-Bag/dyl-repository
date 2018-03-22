package com.dyl.domain;

public class Post {

	private Integer id;
	private Integer blogId;
	private String subject;
	private String body;
	
	public Post() {}
	
	public Post(Integer id, Integer blogId, String subject, String body) {
		this.id = id;
		this.blogId = blogId;
		this.subject = subject;
		this.body = body;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBlog() {
		return blogId;
	}
	public void setBlog(Integer blogId) {
		this.blogId = blogId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
