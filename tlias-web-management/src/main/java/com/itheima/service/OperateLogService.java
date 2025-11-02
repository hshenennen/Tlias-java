package com.itheima.service;

import com.itheima.pojo.OperateLog;
import com.itheima.pojo.PageResult;

public interface OperateLogService {
	// 日志分页查询
	PageResult<OperateLog> page(Integer page, Integer pageSize);
}
