package com.pma.afford.entities;

public class LoginUser {

	private String loginMail;

	private String loginPassword;

	public LoginUser(String loginMail, String loginPassword) {
		super();
		this.loginMail = loginMail;
		this.loginPassword = loginPassword;
	}

	public LoginUser() {
		super();
	}

	public String getLoginMail() {
		return loginMail;
	}

	public void setLoginMail(String loginMail) {
		this.loginMail = loginMail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}
