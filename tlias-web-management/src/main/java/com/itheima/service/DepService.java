package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DepService {
	//查询部门
	public List<Dept> findAll();

	// 通过id，删除部门
	public void deleteID(Integer id);

	//通过名字 添加部门
	public void add(Dept dept);

	//通过id查询部门
	public Dept getIoto(Integer id);

	//修改部门
	public void update(Dept dept);
}
