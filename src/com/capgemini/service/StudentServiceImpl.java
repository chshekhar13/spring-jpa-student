package com.capgemini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.dao.StudentDaoImpl;
import com.capgemini.model.Student;
import com.capgemini.model.User;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	public StudentDaoImpl dao = null;
	
	@Override
	@Transactional
	public boolean admitStudent(Student student) {
		int result = dao.insertStudent(student);
		if(result==1)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public boolean suspendStudent(Student student) {
		int result = dao.deletestudent(student);
		if (result==1)
			return true;
		else
			return false;
	}

	@Override
	public List<Student> showStudents() {
		return dao.selectAllStudents();
	}

	@Override
	public Student showStudentById(int id) {
		return dao.selectStudent(id);
	}

	@Override
	@Transactional
	public boolean upgradeStudent(Student student) {
		int result = dao.updateStudent(student);
		if(result==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean authenticateLogin(User user) {
		int result = dao.checkLogin(user);
		if(result==1)
			return true;
		else
			return false;
	}

}
