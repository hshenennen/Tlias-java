package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.ClazzsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzsController {

	@Autowired
	private ClazzsService clazzsService;

	/**
	 * 3.1 班级列表查询
	 */
	@GetMapping
	public Result getClazzs(ClazzsQueryParam clazzsQueryParam) {
		PageResult<Clazz> pageResult = clazzsService.getClazzs(clazzsQueryParam);
		log.info("查询班级的信息，{}", clazzsQueryParam);
		return Result.success(pageResult);
	}

	/**
	 * 删除班级
	 */
	@DeleteMapping("/{id}")
	public Result deleteClazzs(@PathVariable Integer id) {
		log.info("要删除的id是{}", id);
		clazzsService.deleteClazzs(id);
		return Result.success();
	}

	/**
	 * 添加班级
	 */
	@PostMapping
	public Result postClazzs(@RequestBody Clazz clazz) {
		log.info("data中的数据是{}", clazz);
		clazzsService.postClazzs(clazz);
		return Result.success();
	}

	/**
	 * 根据ID查询班级
	 */
	@GetMapping("/{id}")
	public Result getIdClazzs(@PathVariable Integer id) {
		log.info("要查询的id是{}",id);
		Clazz clazz =clazzsService.getIdClazzs(id);
		return Result.success(clazz);
	}
}
