package com.itheima.controller;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogController {

	@Autowired
	private OperateLogService operateLogService;


	/**
	 * 日志分页查询
	 */
	@GetMapping("/log/page")
	public Result log(Integer page, Integer pageSize) {
		log.info("分页查询员工信息,当前页码:{}，每页记录数:{}", page, pageSize);
		PageResult<OperateLog> pageResult = operateLogService.page(page, pageSize);
		return Result.success(pageResult);
	}
}
