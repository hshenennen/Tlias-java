package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzsQueryParam;
import org.apache.ibatis.annotations.*;

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

	/**
	 * 根据ID查询班级
	 */
	@Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz where id=#{id};")
	Clazz getIdClazzs(Integer id);

	/**
	 *  修改班级
	 */
	@Update("update  clazz set name=#{name},room=#{room},begin_date=#{beginDate},end_date=#{endDate},master_id=#{masterId},subject=#{subject} where id=#{id};")
	void modifyClazzs(Clazz clazz);
}
