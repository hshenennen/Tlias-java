package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DepService {
	/**
	 * 查询所有部门数据
	 */
	public List<Dept> findAll();
}
