package com.socialmedia.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value = { "password", "phone" }) //another way of filtering
@JsonFilter("ParentAcctFilter")
public class ParentsAcct {
	private String username;
	// @JsonIgnore
	private String password;
	private int phone;

	public ParentsAcct(String username, String password, int phone) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
