package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工管理
 */

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpMapper empMapper;


	/**
	 * -- 原始分页   --
	 *
	 * @Override public PageResult PageResult(Integer page, Integer pageSize) {
	 * //1. 获取总记录数
	 * Long total = empMapper.count();
	 * <p>
	 * //2. 获取结果列表
	 * int start=(page - 1) * pageSize;
	 * List<Emp> empList=empMapper.list(start,pageSize);
	 * return new PageResult(total,empList);
	 * }
	 */


	/**
	 * PageHelper分页查询
	 *  page     页码
	 *  pageSize 每页记录数
	 */
	/*
	@Override
	public PageResult PageResult(Integer page, Integer pageSize, String name, String gender, LocalDate begin, LocalDate end) {
		//1．设置分页参数（PageHelper)
		PageHelper.startPage(page, pageSize);

		//2．执行查询
		// PageHelper只会对紧跟在其后的第一条SQL语句进行分页处理

		List<Emp> empList = empMapper.list(name,gender,begin,end);
		//3．解析查询结果，并封装  Page继承了ArrayList,可以进行强转
		Page<Emp> p = (Page<Emp>) empList;
		return new PageResult(p.getTotal(), p.getResult());
	}*/
	@Override
	public PageResult<Emp>  Page(EmpQueryParam empQueryParam) {
		PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

		List<Emp> empList = empMapper.list(empQueryParam);
		Page<Emp> p = (Page<Emp>) empList;
		return new PageResult<Emp> (p.getTotal(), p.getResult());
	}
}
