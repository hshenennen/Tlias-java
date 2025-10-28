package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {
	//分页查询
	PageResult<Student> getPageStudent(StudentQueryParam studentQueryParam);

	//删除学员
	void deleteStudent(List<Integer> ids);

	//增加学员
	void addStudent(Student student);

	//id查询学员
	Student getIdStudent(Integer id);

	//修改学员
	void modifyStudent(Student student);

	//违纪处理
	void disciplinaryStudent(Integer id, Integer score);
}
