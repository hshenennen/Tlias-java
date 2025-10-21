package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpQueryParam {
	private Integer page = 1;//页码
	private Integer pageSize = 10;//每一页的数量
	String name;//名字
	Integer gender;//性别
	//DateTimeFormat用于指定日期/时间字段 在过程中如何进行 格式化（format） 和 解析（parse
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate begin;//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate end;//结束时间

}
