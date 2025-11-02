package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;
import com.itheima.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

	/**
	 * 分页查询操作日志
	 */
	@Autowired
	private OperateLogMapper operateLogMapper;

	@Override
	public PageResult<OperateLog> page(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);

		List<OperateLog> operateLogList = operateLogMapper.getLogList();
		Page<OperateLog> pageInfo = (Page<OperateLog>) operateLogList;
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getResult());
	}
}
