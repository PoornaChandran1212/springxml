package com.kg.springxml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer {
	@Autowired
	private Name name;

	@Autowired
	private Age age;

	@Autowired
	private Address address;

	@Autowired
	private Language language;

	@Autowired
	private Phone phone;
	
	// @Autowired
	// private Country country;

	

	public String getCustomerName() {
		return name.toString();
	}

	public void setCustomerName(String firstName, String lastName) {
		this.name.setFirstName(firstName);
		this.name.setLastName(lastName);
	}

	public String getCustomerAge() {
		return age.getAge();
	}

	public void setCustomerAge(String age) {
		this.age.setAge(age);
	}

	public String getCustomerAddress() {
		return address.getAddress();
	}

	public void setCustomerAddress(String address) {
		this.address.setAddress(address);
	}

	public String getCustomerLanguage() {
		return language.getLanguage();
	}

	public String setCustomerLanguage(String language) {
		return this.language.setLanguage(language);
	}
	public String getCustomerPhone() {
		return phone.getPhone();
	}

	public String setCustomerPhone(String phone) {
		return this.phone.setPhone(phone);
	}

	// public String getCustomerCountry() {
	// 	return country.getCountry();
	// }

	// public String setCustomerCountry(String country) {
	// 	return this.country.setCountry(country);
	// }
	

	public void getscopes() {
		System.out.println("************************");
		System.out.println("Singleton Name " + name);
		System.out.println("Session Age" + age);
		System.out.println("request Address" + address);
		System.out.println("prototype Language" + language);
		System.out.println("scope Application"+ phone);
		// System.out.println("websocket Application"+country);

	}

	
}