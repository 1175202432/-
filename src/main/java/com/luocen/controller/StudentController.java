package com.luocen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luocen.entity.Student;
import com.luocen.service.IStudentService;

@RestController
public class StudentController {
	        
	@Autowired
	private IStudentService studentService;
	
	@RequestMapping("/queryById")
	public Student queryById(int id) {
		Student s = studentService.queryById(id);
		return s;
	}

	@RequestMapping("/queryByPage")
	public List<Student> queryByPage(int currentPage,int pageSize) {
		return studentService.queryByPage(currentPage, pageSize);
	}
	
}
