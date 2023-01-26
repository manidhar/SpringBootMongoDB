package com.example.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="student")
public class Student {
	
	@Id
	private String id;
	private String name;
	@Field(name="mail")
	private String email;
	@Transient
	private double percentage;
	
	private Department department;
	private List<Subject> subjects;
	
	public String getId() {
		return id;
	}
	public double getPercentage() {
		int percentage=0;
		if(null !=subjects && !subjects.isEmpty()){
			int total=0;
			for(Subject subject:subjects){
				total+=subject.getMarksObtained();

			}
			percentage=total/subjects.size();
		}else{
			return 0.0;
		}
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public void setId(String id) {
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	

}
