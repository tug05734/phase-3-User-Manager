package com.example.UserManager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
	
    public User() {
    	this.id = 0;
    	this.name = null;
    	this.email = null;
    	this.password = null;
    }
    
    public User(int id, String name, String email, String password) {
    	this.id = id;
    	this.name = name;
    	this.email = email;
    	this.password = password;
    }
    
    public boolean isEmpty() {
    	if(this.getId() == 0)
    		return true;
    	
    	return false;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return (String.valueOf(id).toString() + " " + name + " " + email + " " + password);
	}
}
