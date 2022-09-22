package com.easytemplates.backend.controller;

public class UserDetailsRequestModel {
	private String username;
	private String email;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String nombre) {
		this.username = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}