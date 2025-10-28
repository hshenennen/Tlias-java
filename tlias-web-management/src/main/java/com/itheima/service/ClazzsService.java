package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;

import java.util.List;

public interface ClazzsService {
	//	班级列表查询
	PageResult<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam);

	//删除班级
	Result deleteClazzs(Integer id);

	//添加班级
	void postClazzs(Clazz clazz);

	//根据ID查询班级
	Clazz getIdClazzs(Integer id);

	//修改班级
	void modifyClazzs(Clazz clazz);

	//查询所有班级
	List<Clazz> allClazzs();
}
