package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
	/**
	 * 分页查询
	 */
	List<Student> getPageStudent(StudentQueryParam studentQueryParam);

	/**
	 * 删除学员
	 */
	void deleteStudent(List<Integer> ids);

	/**
	 *  增加学员
	 */
	@Insert("""
			insert into student(id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id,
			                    violation_count, violation_score, create_time, update_time)
			values (#{id},#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId},#{violationCount},#{violationScore},#{createTime},#{updateTime});""")
	void addStudent(Student student);
}
