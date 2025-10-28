package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;


	/**
	 * 统计员工的职位数量
	 */
	@GetMapping("/empJobData")
	public Result getEmpJobData() {
		log.info("统计员工的职位数量");
		JobOption jobOption = reportService.getEmpJobData();

		return Result.success(jobOption);
	}

	/**
	 * 统计员工的性别数量
	 */
	@GetMapping("/empGenderData")
	public Result getEmpGenderData() {
		List<Map<String, Object>> list = reportService.getEmpGenderData();
		return Result.success(list);
	}

	/**
	 * 学员学历统计
	 */
	@GetMapping("/studentDegreeData")
	public Result getStudentDegreeData() {
		List<Map<String,Object>> list=reportService.getStudentDegreeData();
		return Result.success(list);
	}

}
