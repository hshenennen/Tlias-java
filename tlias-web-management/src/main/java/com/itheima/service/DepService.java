package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DepService {

	public List<Dept> findAll();

	void deleteID(Integer id);
}
