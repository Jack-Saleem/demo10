package com.student.microserv.controller.model;

public class Student {

	private int stdId;
	private String stdName;
	private int stdAge;
	private String stdMail;
	
	public Student() {
		
	}
	
	public Student(int id,String name,int age, String mail) {
		this.stdId=id;
		this.stdName=name;
		this.stdAge=age;
		this.stdMail=mail;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getStdAge() {
		return stdAge;
	}

	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}

	public String getStdMail() {
		return stdMail;
	}

	public void setStdMail(String stdMail) {
		this.stdMail = stdMail;
	}
	
	@Override
	public String toString() {
		return "Student{Id-"+this.stdId+", Name-"+this.stdName+", Age-"+this.stdAge+", EmailId-"+this.stdMail+"}";
	}
}
