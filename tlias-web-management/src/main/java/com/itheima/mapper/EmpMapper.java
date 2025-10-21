package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * 员工管理
 */

@Mapper
public interface EmpMapper {

	/**
	 * ---------------原始分页查询 ----------
	 * // 查询总记录数
	 *
	 * @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
	 * public Long count();
	 * <p>
	 * //查询所有的员工及其对应的部门名称
	 * @Select("select e.*,d.name deptName  from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start },#{pageSize}")
	 * public List<Emp> list(Integer start, Integer pageSize);
	 */


	// 用pageHelper的时候，SQL语句结尾不要加分号（；)
	//@Select("select e.*,d.name deptName  from emp e left join dept d on e.dept_id = d.id order by e.update_time desc")
	public List<Emp> list(EmpQueryParam empQueryParam);


}
