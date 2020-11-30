package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="tbl_new_person")
public class NewPerson extends Person{
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
	//@SequenceGenerator(name="sequence1",initialValue=1,allocationSize=2,sequenceName="seq")
	@Column
	private String email;
	@Column
	private int age;
	@Column
	private int phone;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
