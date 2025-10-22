package com.itheima.service;


import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;

import java.time.LocalDate;
import java.time.LocalTime;

public interface EmpService {
	//分页查询--员工
	PageResult<Emp> Page(EmpQueryParam empQueryParam);

	//添加员工
	void insert(Emp emp);
}
