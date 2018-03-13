package com.example.demo.domain;

public class Friend {
	private String firstName;
	private String lastName;

	public Friend() {
		super();
		this.firstName = null;
		this.lastName = null;
	}

	public Friend(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}