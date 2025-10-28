package com.itheima.controller;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
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
		PageResult<Student> pageResult = studentService.getPageStudent(studentQueryParam);
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

	/**
	 * 增加学员
	 */
	@PostMapping
	public Result addStudent(@RequestBody Student student) {
		log.info("要增加的学生是{}", student);
		studentService.addStudent(student);
		return Result.success();
	}

	/**
	 * id查询学员
	 */
	@GetMapping("/{id}")
	public Result getIdStudent(@PathVariable Integer id) {
		log.info("要查询的学员id是{}", id);
		Student student = studentService.getIdStudent(id);
		return Result.success(student);
	}

	/**
	 * 修改学员
	 */
	@PutMapping
	public Result modifyStudent(@RequestBody Student student) {
		studentService.modifyStudent(student);
		return Result.success();
	}

	/**
	 * 违纪处理
	 */
	@PutMapping("/violation/{id}/{score}")
	public Result disciplinaryStudent(@PathVariable Integer id, @PathVariable Integer score) {
		log.info("要处理的学员id是{}，要扣的分是{}", id, score);
		studentService.disciplinaryStudent(id,score);
		return Result.success();
	}
}
