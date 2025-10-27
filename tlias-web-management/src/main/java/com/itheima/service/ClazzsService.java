package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import com.itheima.pojo.PageResult;

public interface ClazzsService {
    //	班级列表查询
	PageResult<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam);
}
