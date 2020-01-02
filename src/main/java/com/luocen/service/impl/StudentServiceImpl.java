package com.luocen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.luocen.entity.Student;
import com.luocen.mapper.IStudentMapper;
import com.luocen.service.IStudentService;

@Service
@CacheConfig(cacheNames="students")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentMapper studentmapper;
	
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		studentmapper.add(student);
	}

	@Override
	@CacheEvict(allEntries=true)//执行后删除一组缓存
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentmapper.update(student);
	}

	@Override
	@CacheEvict(allEntries=true)//执行后删除一组缓存
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentmapper.deleteById(id);
	}

	@Override
	@Cacheable(key="'student_'+#id")//查询缓存中是否有数据，有则读取，没有则添加
	public Student queryById(int id) {
		// TODO Auto-generated method stub
		return studentmapper.queryById(id);
	}

	@Cacheable(key="'student_'+#p0+'_'+#p1")//查询缓存中是否有数据，有则读取，没有则添加
	@Override
	public List<Student> queryByPage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return studentmapper.queryByPage((currentPage-1)*pageSize, pageSize);
	}

}
