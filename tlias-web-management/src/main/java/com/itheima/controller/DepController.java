package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.service.DepService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepController {

	/**
	 * 查询所有部门的数据
	 */

	@Autowired
	private DepService depService;

	//@RequestMapping(value = "/depts", method = RequestMethod.GET)//method是请求方法
	@GetMapping("/depts")
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
	 * 删除部门－方式三：省略aRequestParam（前端传递的请求参数名与服务端方法形参名一致
	 */
	@DeleteMapping("/depts")
	public Result delete(Integer id) {
		System.out.println("根据ID删除部门" + id);
		depService.deleteID(id);
		return Result.success();
	}
}
