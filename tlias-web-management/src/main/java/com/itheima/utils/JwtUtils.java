package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

	private static String signKey = "5L2g5aW95oiR5pivQmFzZTY05oiR5Y+v5Lul5Zyo57q/57yW56CB6Kej56CB";//密钥
	private static Long expire = 43200000L;//12h

	/**
	 * 生成JWT令牌
	 *
	 * @return
	 */
	public static String generateJwt(Map<String, Object> claims) {

		String jwt = Jwts.builder()//创建JWT的创建对象
				.addClaims(claims) // 1. 添加声明信息到JWT中
				.signWith(SignatureAlgorithm.HS256, signKey)// 2. 使用HS256算法和签名密钥进行签名
				.setExpiration(new Date(System.currentTimeMillis() + expire))// 3. 设置JWT的过期时间
				.compact(); // 4. 生成紧凑的JWT字符串格式

		return jwt;
	}

	/**
	 * 解析JWT令牌
	 *
	 * @param jwt JWT令牌
	 * @return JWT第二部分负载 payload 中存储的内容
	 */
	public static Claims parseJWT(String jwt) {
		Claims claims = Jwts.parser()// 1. 创建JwtParser对象
				.setSigningKey(signKey) // 2. 设置签名密钥
				.parseClaimsJws(jwt) // 3. 解析JWT令牌
				.getBody(); // 4. 获取负载信息

		return claims;
	}
}
