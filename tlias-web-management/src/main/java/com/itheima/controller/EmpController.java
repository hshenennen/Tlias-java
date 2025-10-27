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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * 分页查询
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
	public Result insert(@RequestBody Emp emp) throws Exception {
		empService.insert(emp);
		return Result.success();
	}

/**
 * 删除员工
 */
//方式一：在Controller方法中通过数组来接收
/*	@DeleteMapping
	public Result delete(Integer[] ids) {
		log.info("要删除的id是：{}", Arrays.toString(ids));
		return Result.success();
	}*/

	/**
	 * 删除员工
	 */
	@DeleteMapping
	//@RequestParam 在集合类型中可以省略，但是有bug，不推荐省略
	public Result delete(@RequestParam List<Integer> ids) {
		log.info("要删除的id是:{}", ids);
		empService.delete(ids);
		return Result.success();
	}

	/**
	 * 根据id来查询员工
	 */

	@GetMapping("/{id}")
	public Result getInfo(@PathVariable Integer id) {
		Emp emp = empService.getInfo(id);
		return Result.success(emp);
	}

	/**
	 * 修改员工
	 */
	@PutMapping
	public Result update(@RequestBody Emp emp) {
		empService.update(emp);
		return Result.success();
	}

	/**
	 * 查询所有的班主任
	 */
	@GetMapping("/list")
	public Result getAllLIst() {
		List<Emp> list = empService.getAllLIst();
		return Result.success(list);
	}
}
