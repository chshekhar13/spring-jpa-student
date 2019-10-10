package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Login")
public class User {
	@Id
	@NotEmpty(message="Username is required!")
	@Size(min=1, max=10, message="Username should be 1-10 characters long!")
	@Column(name="username")
	private String username;
	
	@NotEmpty(message="Password is required!")
	@Size(min=1, max=10, message="Password should be 1-10 characters long!")
	@Column(name="password")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
}
