package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ClazzsMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzsServiceImpl implements ClazzsService {

	@Autowired
	private ClazzsMapper clazzsMapper;


	/**
	 * 班级列表查询
	 */
	@Override
	public PageResult<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam) {
		PageHelper.startPage(clazzsQueryParam.getPage(), clazzsQueryParam.getPageSize());

		List<Clazz> clazzes = clazzsMapper.getClazzs(clazzsQueryParam);

		Page<Clazz> page = (Page<Clazz>) clazzes;

		return new PageResult<Clazz>(page.getTotal(), page.getResult());
	}

	//删除班级
	@Override
	public void deleteClazzs(Integer id) {
      clazzsMapper.deleteClazzs(id);
	}
}
