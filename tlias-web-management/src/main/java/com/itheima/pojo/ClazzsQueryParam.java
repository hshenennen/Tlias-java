package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzsQueryParam {
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate begin;//开始时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate end;//结束时间
	private Integer page = 1;
	private Integer pageSize = 10;


}
