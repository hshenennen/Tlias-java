package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工管理
 */

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;

	@Override
	public PageResult PageResult(Integer page, Integer pageSize) {
		//1. 获取总记录数
		Long total = empMapper.count();

		//2. 获取结果列表
		int start=(page - 1) * pageSize;
		List<Emp> empList=empMapper.list(start,pageSize);
		return new PageResult(total,empList);
	}
}
