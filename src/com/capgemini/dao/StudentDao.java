package com.capgemini.dao;

import java.util.List;

import com.capgemini.model.Student;
import com.capgemini.model.User;

public interface StudentDao {
	public int insertStudent(Student student);
	public int deletestudent(Student student);
	public List<Student> selectAllStudents();
	public Student selectStudent(int id);
	public int updateStudent(Student student);
	public int checkLogin(User user);
	
}
