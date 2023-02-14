package com.hibernate.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_privilages")
public class UserPrivilages {
	
	@Id
	private int id;
	private String name;
	
	public UserPrivilages(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserPrivilages [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
	
	
	

}
