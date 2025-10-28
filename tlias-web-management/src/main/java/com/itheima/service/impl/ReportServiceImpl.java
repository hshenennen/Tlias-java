package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private EmpMapper empMapper;

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 统计员工的职位数量
	 */
	@Override
	public JobOption getEmpJobData() {
		//获取list里面的map集合  把map中的key和value分开到两个List集合中
		List<Map<String, Object>> list = empMapper.countEmpJobData();
		List<Object> pos = list.stream().map(item -> item.get("pos")).toList();
		List<Object> num = list.stream().map(item -> item.get("num")).toList();

		return new JobOption(pos, num);
	}

	/**
	 * 统计员工的性别数量
	 */
	@Override
	public List<Map<String, Object>> getEmpGenderData() {
		return empMapper.countEmpGenderData();
	}
	/**
	 * 学员学历统计
	 */
	@Override
	public List<Map<String, Object>> getStudentDegreeData() {
		return studentMapper.getStudentDegreeData();
	}

}
