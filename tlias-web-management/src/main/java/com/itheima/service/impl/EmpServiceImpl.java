package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	@Autowired
	private EmpExprMapper empExprMapper;

	@Autowired
	private EmpLogService empLogService;


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

	/**
	 * 分页查询 -- 员工
	 *
	 * @param empQueryParam
	 * @return
	 */
	@Override
	public PageResult<Emp> Page(EmpQueryParam empQueryParam) {
		PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

		List<Emp> empList = empMapper.list(empQueryParam);
		Page<Emp> p = (Page<Emp>) empList;
		return new PageResult<Emp>(p.getTotal(), p.getResult());
	}

	/**
	 * 添加员工
	 *
	 * @param emp
	 */
	@Transactional(rollbackFor = {Exception.class}) //事务管理  这个注解会自动进行事务的提交和退回
	@Override
	public void insert(Emp emp) {
		try {
			//要补充空缺的员工信息(数据库要的)
			emp.setUpdateTime(LocalDateTime.now());
			emp.setUpdateTime(LocalDateTime.now());
			empMapper.insert(emp);

			//int i=1/0;// 计算异常算运行式异常
			// 运行式异常
//		if (true){
//			throw new Exception("出错了！！！！！");
//		}

			//添加工作经历
			Integer empId = emp.getId();
			List<EmpExpr> exprList = emp.getExprList();
			//CollectionUtils是 Spring Boot中的工具类,isEmpty方法是判断是否为空
			if (!CollectionUtils.isEmpty(exprList)) {
				//遍历集合，让员工找到，自己的经历  为empId赋值
				exprList.forEach(empExpr -> empExpr.setEmpId(empId));
				empExprMapper.insertBatch(exprList);
			}
		} finally {
			//记录操作的日志  无论是成功还是失败都要记录日志
			EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "添加员工" + emp);
			//要在失败的时候，也要记录日志，就要再开启一个事件
			empLogService.insertLog(empLog);
		}
	}

	@Transactional(rollbackFor = {Exception.class})//遇到异常直接滚会
	//删员工的同时，要把员工的工作的经历也要删除，所以要用事件来管理
	@Override
	public void delete(List<Integer> ids) {
        //删除员工
		empMapper.delete(ids);

        //删除员工经历
		empExprMapper.delete(ids);
	}


}
