package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
	private String name;//学员姓名
	private Integer degree;//学历
	private Integer clazzId;//班级
	private Integer page = 1;
	private Integer pageSize = 10;

}
