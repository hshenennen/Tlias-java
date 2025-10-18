package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepController {

	/**
	 * 查询所有部门的数据
	 *
	 *
	 */

	@Autowired
	private DepService depService;

	//@RequestMapping(value = "/depts", method = RequestMethod.GET)//method是请求方法
	@GetMapping("/depts")
	public Result findAll() {
		return Result.success(depService.findAll());
	}
}
