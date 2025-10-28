package com.itheima.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.DepService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//一个完整的请求路径，应该是类上的 @RequestMapping 的value属性 + 方法上的 @RequestMapping的value属性。
@Slf4j  //可以注解的写法-- log日志
@RequestMapping("/depts")
@RestController
public class DepController {
	//private static final Logger log = LoggerFactory.getLogger(DepController.class);//log日志的写法是固定的
	/**
	 * 查询所有部门的数据
	 */

	@Autowired
	private DepService depService;//面对接口编程

	@Autowired
	private EmpMapper empMapper;

	//@RequestMapping(value = "/depts", method = RequestMethod.GET)//method是请求方法
	@GetMapping
	public Result findAll() {
		return Result.success(depService.findAll());
	}

	/**
	 * 删除部门 方法一：HttpServLetRequest 获取请求参数
	 */

	//	@DeleteMapping("/depts")
	//	public Result delete(HttpServletRequest request) {
	//		String idStr = request.getParameter("id");
	//		int id = Integer.parseInt(idStr);
	//		System.out.println("根据ID删除部门" + id);
	//		return Result.success();
	//	}

	/**
	 * 删除部门－方式二：@RequestParam
	 * 注意事项：一旦声明了aRequestParam，该参数在请求时必须传递，如果不传递将会报错．(默认 require d为 true)
	 */

	//	@DeleteMapping("/depts")
	//	public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
	//		System.out.println("根据ID删除部门" + deptId);
	//		return Result.success();
	//	}

	/**
	 * 删除部门－方式三：省略@RequestParam（前端传递的请求参数名与服务端方法形参名一致
	 */
	@Transactional(rollbackFor = {Exception.class})
	@DeleteMapping
	public Result delete(Integer id) throws Exception {
		//System.out.println("根据ID删除部门" + id);
		log.info("根据ID删除部门 {}", id); //{}占位符，防止字符串的拼接
		Integer count = empMapper.getJobEmp(id);
		log.info("数量是{}", count);

		if (count > 0) {
			//throw new Exception("对不起，当前部门下有员工，不能直接删除！");
			return Result.error("对不起，当前部门下有员工，不能直接删除！");
		} else {
			depService.deleteID(id);
		}
		return Result.success();
	}

	/**
	 * 添加部门
	 */
	@PostMapping
	public Result add(@RequestBody Dept dept) {
		depService.add(dept);
		return Result.success();
	}

	/**
	 * 通过id来查部门  方法一@PathVariable("动态路径名")
	 */
	//	@GetMapping("/depts/{id}")
	//	public Result getIoto(@PathVariable("id") Integer deptId) {
	//		System.out.println("获取的id是：" + deptId);
	//		return Result.success();
	//	}

	/**
	 * 通过id来查部门  方法二 动态路径名和变量名一样,@PathVariable中的value可以省略
	 */
	@GetMapping("/{id}")
	public Result getIoto(@PathVariable Integer id) {
		return Result.success(depService.getIoto(id));

	}

	/**
	 * 修改部门
	 */
	@PutMapping
	public Result update(@RequestBody Dept dept) {
		depService.update(dept);
		return Result.success();
	}
}
