package com.capgemini.aspect;


import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerMain {
	Logger logger;
	public LoggerMain() {
		//PropertyConfigurator.configure("../resources/log4j.properties");
		System.out.println("--- LoggerMain ---");
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream input = classLoader.getResourceAsStream("log4j.properties");
		PropertyConfigurator.configure(input);
		System.out.println("--- LoggerMain ---");
		logger = Logger.getLogger(LoggerMain.class);
	}
	
	@Before("execution(public String listAllStudents(..))")
	public void logForSelectAll(){
		System.out.println("Logger logging the message before viewing all students!");
		logger.info("Before Viewing All");
	}
	
	/*@Pointcut("execution(* addStudent(..))")
	public void pointCut(){
		
	}
	
	@Before("pointCut()")
	public void logForViewStudents1(){
		System.out.println("Logger logging the message before1!");
	}*/
	
	
	/*@Before("execution(public String homePage())")
	public void logForHomePage(){
		System.out.println("Logger logging the message before opening login!");
		logger.info("Login");
	}
	@Before("execution(public String addStudentProcess(..))")
	public void logForCreateStudent(){
		System.out.println("Logger logging the message before creating student!");
		logger.info("Before Adding");
	}*/
	/*@Before("execution(public String deleteStudentProcess(..))")
	public void logForDeleteStudent(){
		System.out.println("Logger logging the message before deleting student!");
	}
	@Before("execution(public String updateStudentPage(..))")
	public void logForUpdateStudent(){
		System.out.println("Logger logging the message before updating student!");
	}
	@Before("execution(public String searchStudent(..))")
	public void logForViewingAStudent(){
		System.out.println("Logger logging the message before viewing one student!");
	}*/
	
}
