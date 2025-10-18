package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DepService {

	@Autowired
	private DeptMapper deptMapper;

	/**
	 * 查询所有部门数据
	 */
	@Override
	public List<Dept> findAll() {
		return deptMapper.findAll();
	}

	/**
	 * 通过id来删部门
	 */
	@Override
	public void deleteID(Integer id) {
		deptMapper.deleteID(id);
	}
}
