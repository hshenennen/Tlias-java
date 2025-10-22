package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 员工管理
 */

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	/**
	 * 分页查询 --原始分页
	 */

	/*@GetMapping
	public Result page(@RequestParam(defaultValue = "1") Integer page,
	                   @RequestParam(defaultValue = "10") Integer pageSize,
	                   String name,
	                   String gender,
	                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
	                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
                       //DateTimeFormat用于指定日期/时间字段 在过程中如何进行 格式化（format） 和 解析（parse）
	) {
		log.info("查询员工的信息，page={}，pageSize={}", page, pageSize);
		PageResult pageResult = empService.PageResult(page, pageSize,name,gender,begin,end);
		return Result.success(pageResult);
	}*/

	/**
	 * 分页查询 --原始分页
	 */
	@GetMapping
	public Result page(EmpQueryParam empQueryParam) {
		log.info("查询员工的信息，{}", empQueryParam);
		PageResult<Emp> pageResult = empService.Page(empQueryParam);
		return Result.success(pageResult);
	}

	/**
	 * 添加员工
	 */
	@PostMapping
	public Result insert(@RequestBody Emp emp) {
		empService.insert(emp);
		return Result.success();
	}
}
