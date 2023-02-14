package com.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "address_one")
class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	private String city;
	private String zipcode;
	
	@OneToOne(mappedBy = "address",fetch = FetchType.LAZY)
	private Student student;
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address( String street, String city, String zipcode) {
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	public int getId() {
		return id;
	}

	public Student getStudent() {
		return student;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
