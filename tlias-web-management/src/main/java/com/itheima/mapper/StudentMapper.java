package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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
	 * 增加学员
	 */
	@Insert("""
			insert into student(id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id,
			                    violation_count, violation_score, create_time, update_time)
			values (#{id},#{name},#{no},#{gender},#{phone},#{idCard},#{isCollege},#{address},#{degree},#{graduationDate},#{clazzId},#{violationCount},#{violationScore},#{createTime},#{updateTime});""")
	void addStudent(Student student);

	/**
	 * id查询学员
	 */
	@Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where id=#{id};")
	Student getIdStudent(Integer id);

	/**
	 * 修改学员
	 */
	@Update("update student set name=#{name},no=#{no},gender=#{gender},phone=#{phone},id_card=#{idCard},is_college=#{isCollege},address=#{address},degree=#{degree},graduation_date=#{graduationDate},clazz_id=#{clazzId} where id=#{id};")
	void modifyStudent(Student student);

	@Update("update student set violation_count=#{violationCount},violation_score=#{violationScore} where id=#{id} ")
	void disciplinaryStudent(Student student);

	/**
	 * 学员学历统计
	 */
	@MapKey("name")
	List<Map<String, Object>> getStudentDegreeData();

	/**
	 * 班级人数统计
	 */
	@MapKey("name")
	List<Map<String, Object>> getStudentCountData();

	/**
	 * id查询班级是否有学员
	 */
	@Select("select count(*) from student where clazz_id=1 order by clazz_id;")
	Integer getIdClass(Integer id);

}
