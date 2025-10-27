package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	/**
	 * 删除学员
	 */
	@DeleteMapping("/{ids}")
	public Result deleteStudent(@PathVariable List<Integer> ids) {
		log.info("要删除的学员id是{}", ids);
     studentService.deleteStudent(ids);
		return Result.success();
	}
}
