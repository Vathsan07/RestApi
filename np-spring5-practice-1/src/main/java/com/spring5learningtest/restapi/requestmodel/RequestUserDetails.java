/**
 * 
 */
package com.spring5learningtest.restapi.requestmodel;

import javax.validation.constraints.NotNull;

/**
 * @author vathsan
 * From Request Body, while consuming the details this pojo class is used
 */
public class RequestUserDetails {

	private String firstName;
	@NotNull
	private String mail;
	private int age;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
