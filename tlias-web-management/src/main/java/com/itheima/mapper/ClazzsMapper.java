package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzsMapper {

	/**
	 * 班级列表查询
	 */
	List<Clazz> getClazzs(ClazzsQueryParam clazzsQueryParam);

	/**
	 * 删除班级
	 */
	@Delete("delete from clazz where id = #{id};")
	void deleteClazzs(Integer id);

	@Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime});")
	void postClazzs(Clazz clazz);
}
