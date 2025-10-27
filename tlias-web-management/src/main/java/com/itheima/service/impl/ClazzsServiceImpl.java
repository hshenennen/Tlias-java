package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.autoconfigure.PageHelperProperties;
import com.itheima.mapper.ClazzsMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzsService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzsServiceImpl implements ClazzsService {

	@Autowired
	private ClazzsMapper clazzsMapper;
	@Autowired
	private PageHelperProperties pageHelperProperties;
	@Autowired
	private ListableBeanFactory listableBeanFactory;

	/**
	 * 班级列表查询
	 */
	@Override
	public PageResult<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam) {
		PageHelper.startPage(clazzsQueryParam.getPage(),clazzsQueryParam.getPageSize());

		List<Clazz> clazzes =clazzsMapper.getClazzs(clazzsQueryParam);

		Page<Clazz> page=(Page<Clazz>) clazzes;

		return new PageResult<Clazz>(page.getTotal(),page.getResult());
	}
}
