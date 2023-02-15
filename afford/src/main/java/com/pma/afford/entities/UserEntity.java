package com.pma.afford.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;

	@Column(name = "userFirstName", nullable = false, length = 45)
	private String userFirstName;

	@Column(name = "userLastName", nullable = false, length = 45)
	private String userLastName;

	@Column(name = "userMail", nullable = false, unique = true, length = 45)
	private String userMail;

	@Column(name = "userPassword", nullable = false, length = 100)
	private String userPassword;
	
	@Column(name = "userPhoneNumber", nullable = false, length = 12)
	private long userPhoneNumber;

	public UserEntity() {
		super();
	}

	public UserEntity(String userFirstName, String userLastName, String userMail, String userPassword,
			Integer userPhoneNumber) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userPhoneNumber = userPhoneNumber;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public UserEntity(long userPhoneNumber) {
		super();
		this.userPhoneNumber = userPhoneNumber;
	}
}
