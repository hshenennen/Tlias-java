package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import com.itheima.pojo.PageResult;

public interface ClazzsService {
	//	班级列表查询
	PageResult<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam);

	//删除班级
	void deleteClazzs(Integer id);

	//添加班级
	void postClazzs(Clazz clazz);
}
