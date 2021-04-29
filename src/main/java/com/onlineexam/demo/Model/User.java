package com.onlineexam.demo.Model;

public class User {
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone_number;
	private String password;
	private String gender;
	private Boolean Enabled;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Boolean getEnabled() {
		return Enabled;
	}
	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", phone_number="
				+ phone_number + ", password=" + password + ", gender=" + gender + ", Enabled=" + Enabled + "]";
	}
}