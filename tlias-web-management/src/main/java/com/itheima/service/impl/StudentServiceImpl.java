package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 分页查询
	 */
	@Override
	public PageResult<Student> getPageStudent(StudentQueryParam studentQueryParam) {
		//开启分页
		PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

		List<Student> studentList = studentMapper.getPageStudent(studentQueryParam);

		Page<Student> page = (Page<Student>) studentList;
		return new PageResult<>(page.getTotal(), page.getResult());
	}

	/**
	 * 删除学员
	 */
	@Override
	public void deleteStudent(List<Integer> ids) {
        studentMapper.deleteStudent(ids);
	}


}
