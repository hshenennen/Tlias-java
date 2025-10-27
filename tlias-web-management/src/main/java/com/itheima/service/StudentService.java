package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

public interface StudentService {
	//分页查询
	PageResult<Student> getPageStudent(StudentQueryParam studentQueryParam);
}
