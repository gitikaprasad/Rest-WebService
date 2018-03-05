package com.jpa.ZaaxiitJpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "people")
public class Users {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.PERSIST,orphanRemoval=true)
	@JoinColumn(name = "user_id")
	private List<UsersLog> userLogs=new ArrayList<>();;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private UserContact userContact;

	public Users() {

	}

	public UserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public Users(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public List<UsersLog> getUserLogs() {
		return userLogs;
	}

	public void setUserLogs(List<UsersLog> userLogs) {
		this.userLogs = userLogs;
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

}
