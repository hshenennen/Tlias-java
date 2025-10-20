package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */

@Mapper
public interface EmpMapper {
	// 查询总记录数
	@Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
	public Long count();

	//查询所有的员工及其对应的部门名称
	@Select("select e.*,d.name deptName  from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start },#{pageSize};")
	public List<Emp> list(Integer start, Integer pageSize);

}
