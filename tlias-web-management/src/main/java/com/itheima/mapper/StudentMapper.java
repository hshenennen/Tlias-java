package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
	/**
	 * 分页查询
	 */
	List<Student> getPageStudent(StudentQueryParam studentQueryParam);
}
