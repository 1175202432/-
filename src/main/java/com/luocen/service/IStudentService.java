package com.luocen.service;

import java.util.List;

import com.luocen.entity.Student;

public interface IStudentService {

	public void add(Student student);
	
	public void update(Student student);
	
	public void deleteById(int id);
	
	public Student queryById(int id);
	
	public List<Student> queryByPage(int currentPage,int pageSize);
}
