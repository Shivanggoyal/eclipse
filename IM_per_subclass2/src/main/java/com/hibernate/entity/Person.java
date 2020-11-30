package com.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="tbl_person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="person_generator")
	@TableGenerator(name="person_generator",initialValue=1,allocationSize=2,table="unique_generator")
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence1")
	//@SequenceGenerator(name="sequence1",initialValue=1,allocationSize=2,sequenceName="seq")
	private int person_id;
	@Column
	private String person_name;
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
}
