package com.luocen.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.luocen.entity.Student;

public interface IStudentMapper {
	
	@Insert("insert into student(name,username,password,sex,age,birthday,createTime) values(#{name},#{username},#{password},#{sex},#{age},#{birthday},now())")
	public void add(Student student);
	
	@Update("update student set name=#{name},username=#{username},password=#{password},sex=#{sex},age=#{age},birthday=#{birthday},nom()")
	public void update(Student student);
	
	@Delete("delete from student where id = #{id}")
	public void deleteById(int id);
	
	@Select("select * from student where id = #{id}")
	public Student queryById(int id);
	
	@Select("select * from student limit #{start},#{pageSize}")
	public List<Student> queryByPage(@Param("start")int start,@Param("pageSize")int pageSize);
}
