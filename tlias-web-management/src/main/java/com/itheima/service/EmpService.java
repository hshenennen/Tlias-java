package com.itheima.service;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface EmpService {
	//分页查询--员工
	PageResult<Emp> Page(EmpQueryParam empQueryParam);

	//添加员工
	void insert(Emp emp) ;

	//删除员工
	void delete(List<Integer> ids);

	//根据id查询员工
	Emp getInfo(Integer id);

	//修改员工
	void update(Emp emp);

	//查询所有的班主任
	List<Emp> getAllLIst();

	//登录
	LoginInfo login(Emp emp);
}
