package com.rest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

	private Long employeeId;
	private String firstName;
	private String lastName;
	private int age;
	
	@JsonCreator
	public Employee(@JsonProperty("employeeId") Long employeeId,@JsonProperty("firstName") String firstName,
			@JsonProperty("lastName") String lastName,@JsonProperty("age") int age) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Employee() {
		
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee id :- "+getEmployeeId());
		builder.append("First Name :- "+getFirstName());
		builder.append("Last Name :- "+getLastName());
		builder.append("Age :- "+getAge());
		return builder.toString();
	}
}