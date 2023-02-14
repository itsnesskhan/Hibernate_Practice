package com.hibernate.onetomany;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_number")
public class MobileNumber {

	@Id
	private long number;
	private String type;
	private String operator;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Student student;

	public MobileNumber() {
	}

	public MobileNumber(long number, String type, String operator, Student student) {
		super();
		this.number = number;
		this.type = type;
		this.operator = operator;
		this.student = student;
	}

	public long getNumber() {
		return number;
	}

	public String getType() {
		return type;
	}

	public String getOperator() {
		return operator;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "MobileNumber [number=" + number + ", type=" + type + ", operator=" + operator + "]";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
