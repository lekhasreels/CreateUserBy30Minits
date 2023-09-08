package com.user;

import java.util.Date;

public class User {
	private String name;
    private String email;
    private Date creationTime;
 // Default constructor
    public User() {
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
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public User(String name, String email, Date creationTime) {
		super();
		this.name = name;
		this.email = email;
		this.creationTime = creationTime;
	}

}
