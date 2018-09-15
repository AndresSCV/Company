package com.company.employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	public enum Type{ADMIN, GENERIC}
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	private String name;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private User.Type type;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User.Type getType() {
		return type;
	}
	public void setType(User.Type type) {
		this.type = type;
	}
	
	
	

}
