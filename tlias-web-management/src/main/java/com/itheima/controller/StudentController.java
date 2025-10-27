package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	/**
	 * 分页查询
	 */
	@GetMapping
	public Result getPageStudent(StudentQueryParam studentQueryParam) {
		PageResult<Student>  pageResult =studentService.getPageStudent(studentQueryParam);
		return Result.success(pageResult);
	}
}
