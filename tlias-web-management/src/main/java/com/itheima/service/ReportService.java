package com.itheima.service;


import com.itheima.pojo.JobOption;
import com.itheima.pojo.StudentOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    //统计员工的职位数量
	JobOption getEmpJobData();

	//统计员工的性别数量
	List<Map<String,Object>> getEmpGenderData();

	//学员学历统计
	List<Map<String, Object>> getStudentDegreeData();

	//班级人数统计
	StudentOption getStudentCountData();
}
