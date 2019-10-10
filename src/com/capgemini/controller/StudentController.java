package com.capgemini.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.model.Student;
import com.capgemini.model.User;
import com.capgemini.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String homePage(Model model){
		model.addAttribute("loginForm",new User());
		return "login";
	}
	
	@RequestMapping(path="/login.do",method=RequestMethod.POST)
	public String login(@Valid @ModelAttribute("loginForm") User user, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "login";
		}
		boolean result = service.authenticateLogin(user);
		if(result==true)
			return "index";
		else
			return "error";
	}
	@RequestMapping(path="/addStudentPage",method=RequestMethod.GET)
	public String addStudentProcess(Model model1, Model model2){
		model1.addAttribute("addForm",new Student());
		List<Student> list= service.showStudents();
		model2.addAttribute("studentList", list);
		return "addStudent";
	}
	
	
	@RequestMapping(path="/addStudent.do",method=RequestMethod.POST)
	public String addStudent(@Valid Model model,@ModelAttribute("addForm") Student student, BindingResult bindingResult){
		//System.out.println("binding result hasErrors: "+bindingResult.hasErrors());
		if(bindingResult.hasErrors()){
			return "addStudent";
		}
		boolean result = service.admitStudent(student);
		List<Student> list= service.showStudents();
		model.addAttribute("studentList", list);
		if(result==true)
			return "addStudent";
		else
			return "error";
	}
	
	@RequestMapping(path="/deleteStudentPage",method=RequestMethod.GET)
	public String deleteStudentProcess(Model model){
		model.addAttribute("deleteForm",new Student());
		return "deleteStudent";
	}
	

	@RequestMapping(path="/deleteStudent.do",method=RequestMethod.POST)
	public String deleteStudent(@Valid @ModelAttribute("deleteForm") Student student, BindingResult bindingResult){
		/*if(bindingResult.hasErrors()){
			return "deleteStudent";
		}*/
		boolean result = service.suspendStudent(student);
		if(result==true)
			return "redirect:/viewStudents.do";
		else
			return "error";
	}
	
	
	
	
	@RequestMapping(path="/updateStudentPage")
	public String blala(){
	return "update";
	}
	@RequestMapping(path="/modifyStudent")
	public String updateStudentPage(Model model, @RequestParam("studentId")int id){
	Student student=service.showStudentById(id);
	model.addAttribute("student", student);
	return "updateStudent";
	}
	@RequestMapping(path="/updateStudent.do", method=RequestMethod.POST)
	public String processUpdateStudent(@RequestParam("studentId")int id, @RequestParam("studentName")String name, @RequestParam("studentScore")float score){
	Student student= new Student();
	student.setStudentId(id);
	student.setStudentName(name);
	student.setStudentScore(score);
	boolean result=service.upgradeStudent(student);
	if(result)
		return "redirect:/viewStudents.do";
	else
		return "error";
	}


	
	/*@RequestMapping(path="/updateStudentPage")
	public String blala(){
	return "update";
	}
	@RequestMapping(path="/modifyStudent")
	public String updateStudentPage(Model model, @RequestParam("studentId")int id){
	Student student=service.showStudentById(id);
	model.addAttribute("student", student);
	return "updateStudent";
	}
	
	
	
	@RequestMapping(path="/updateStudentPage")
	public String updateStudentProcess(Model model) {
		model.addAttribute("updateForm",new Student());
		return "update";
	}
	
	@RequestMapping(path="/updateStudent.do",method=RequestMethod.POST)
	public String updateStudent(@Valid @ModelAttribute("updateForm") Student student, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "update";
		}
		boolean result = service.upgradeStudent(student);
		if(result==true)
			return "redirect:/viewStudents.do";
		else
			return "error";
	}*/
	
	@RequestMapping(path="/viewStudents.do")
	public String listAllStudents(Model model){
		List<Student> list = service.showStudents();
		model.addAttribute("studentList", list);
		return "viewStudents";
	}
	
	@RequestMapping(path="/searchStudentPage", method=RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute("searchForm",new Student());
		return "searchStudent";
	}
	
	@RequestMapping(path="/searchStudent.do")
	public String searchStudent(Model model,@Valid @ModelAttribute("searchForm") Student student, BindingResult bindingResult){
		/*if(bindingResult.hasErrors()){
			return "searchStudent";
		}*/
		int id = student.getStudentId(); 
		student = service.showStudentById(id);
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		model.addAttribute("studentList", list);
		return "viewStudents";
	}
	
	
}
