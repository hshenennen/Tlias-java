package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
	/**
	 * 查询所有部门
	 */
	//方式一：手动结果映射
//	@Results({
//			@Result(property = "createTime", column = "create_time"),
//			@Result(property = "updateTime", column = "update_time")
//	})

	@Select("select id, name, create_time, update_time from dept order by update_time desc;")
	List<Dept> findAll();
}
