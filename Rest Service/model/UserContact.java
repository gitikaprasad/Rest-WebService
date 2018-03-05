package com.jpa.ZaaxiitJpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_contact")
public class UserContact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int phone;

	public UserContact() {
	}

	public UserContact(int id, int phone) {
		super();
		this.id = id;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
