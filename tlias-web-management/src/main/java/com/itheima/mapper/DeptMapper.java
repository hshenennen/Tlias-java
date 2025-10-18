package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

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

	/**
	 * 通过id来删部门
	 */
	@Delete("delete from dept where id=#{id}")
	void deleteID(Integer id);

	/**
	 * 添加部门
	 */
	//我们在配置中开启的驼峰命名，就对应	 create_time -- createTime
	@Insert("insert into dept(name, create_time, update_time) values(#{name},#{createTime},#{updateTime}) ")
	void insert(Dept dept);

	/**
	 * 通过id来查询部门
	 */
	@Select("select id, name, create_time, update_time from dept where id=#{id}")
	Dept getIoto(Integer id);
}
