package com.itheima.controller;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping
	public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
		log.info("查询员工的信息，page={}，pageSize={}", page, pageSize);
		PageResult pageResult = empService.PageResult(page, pageSize);
		return Result.success(pageResult);
	}


}
