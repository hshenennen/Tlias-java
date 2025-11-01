package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
	private Integer id;// 用户id
	private String username;// 用户名
	private String name;// 用户姓名
	private String token;// 用户令牌
}
