package com.hibernate.manytomany;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class UserRoles {

	@Id
	private int id;
	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "roles_privilages",
		joinColumns = @JoinColumn(name = "role_id"),
		inverseJoinColumns = @JoinColumn(name = "privilage_id"))
	private Set<UserPrivilages> privilages;

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

	public Set<UserPrivilages> getPrivilages() {
		return privilages;
	}

	public void setPrivilages(Set<UserPrivilages> privilages) {
		this.privilages = privilages;
	}

	@Override
	public String toString() {
		return "UserRoles [id=" + id + ", name=" + name + "]";
	}

}
