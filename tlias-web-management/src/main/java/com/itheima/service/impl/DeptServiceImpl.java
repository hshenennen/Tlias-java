package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DepService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

	/**
	 * 添加部门
	 */
	@Override
	public void add(Dept dept) {
		//先补全dept中的属性
		dept.setCreateTime(LocalDateTime.now());//LocalDateTime.now() 获取现在的系统时间
		dept.setUpdateTime(LocalDateTime.now());
		//再抛给mapper
		deptMapper.insert(dept);

	}

	/**
	 * 通过id来查询部门
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Dept getIoto(Integer id) {
		return deptMapper.getIoto(id);
	}

	/**
	 * 修改部门
	 */
	@Override
	public void update(Dept dept) {
		//更新时间
		dept.setUpdateTime(LocalDateTime.now());
		deptMapper.update(dept);
	}
}
