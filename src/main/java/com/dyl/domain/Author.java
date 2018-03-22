package com.dyl.domain;

public class Author {

	private Integer id;
	private String name;
	private String email;
	private String gender;
	private String address;
	private String selfDesc;
	
	public Author() {}
	
	public Author(Integer id, String name, String email, String gender, String address, String selfDesc) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.selfDesc = selfDesc;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSelfDesc() {
		return selfDesc;
	}
	public void setSelfDesc(String selfDesc) {
		this.selfDesc = selfDesc;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", address="
				+ address + ", selfDesc=" + selfDesc + "]";
	}
	
}
