package com.itheima;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
	//生成JWT令牌
	@Test
	public void estGenerateJwt() {
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("id", 1);
		dataMap.put("name", "admin");
		String jonsWebToken = Jwts.builder()//创建JWT的创建对象
				//添加自定义数据
				.signWith(SignatureAlgorithm.HS256, "5L2g5aW95oiR5pivQmFzZTY05oiR5Y+v5Lul5Zyo57q/57yW56CB6Kej56CB")//指定加密算法，秘钥
				.addClaims(dataMap)//添加自定义数据
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 1000))//置过期时间
				.compact();//生成令牌
		System.out.println(jonsWebToken);
	}

	//解析JWT令牌
	@Test
	public void estParseJwt() {
		String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiYWRtaW4iLCJpZCI6MSwiZXhwIjoxNzYxNzQ4MDc2fQ.7QOlc0TKaeHA794wRNZDpluzpUysr3rJ7cXLZiIaez4";
		Map<String, Object> claims = Jwts.parser()//创建JWT的解析对象
				.setSigningKey("5L2g5aW95oiR5pivQmFzZTY05oiR5Y+v5Lul5Zyo57q/57yW56CB6Kej56CB")//指定秘钥
				.parseClaimsJws(jwt)//解析令牌
				.getBody();//获取自定义的数据

		System.out.println(claims);
	}
}
