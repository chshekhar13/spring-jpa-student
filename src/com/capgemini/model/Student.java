package com.capgemini.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	@Id
	
	//Wrong validation
	
	//@NotNull(message="Student ID is required!")
	//@Size(min=1, max=10, message="Student ID should be 1-4 digits long!")
	//@Min(value=50,message="Student ID should be 1-4 digits long!")
	//@Max(value=9999,message="Student ID should be 1-4 digits long!")
	@Column(name="studentId")
	private Integer studentId;
	
	@NotEmpty(message="Student Name is required!")
	@Size(min=1, max=10, message="Student Name should be 1-10 characters long!")
	@Column(name="studentName")
	private String studentName;
	
	//Wrong validation
	
	//@Min(value=1,message="Student Score should be 1-5 digits long!")
	//@Max(value=99999,message="Student Score should be 1-5 digits long!")
	//@NotNull(message="Student Score is required!")
	//@Size(min=1, max=10, message="Student Score should be 1-5 digits long!")
	@Column(name="studentScore")
	private float studentScore;
	

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public float getStudentScore() {
		return studentScore;
	}
	public void setStudentScore(float studentScore) {
		this.studentScore = studentScore;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + getStudentId() + ", studentName="
				+ studentName + ", studentScore=" + studentScore + "]";
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
}
