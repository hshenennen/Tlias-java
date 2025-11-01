package com.itheima.filter;

import com.itheima.utils.CurrentHolder;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")

public class TokenFilter implements Filter {

	/**
	 * 令牌校验过滤器
	 */

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		// 强转是为了使用 HTTP 特有的方法（如获取 header、设置状态码等）。
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		//1. 获取请求url。
		String url = request.getRequestURI();

		//2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
		if (url.contains("login")) {
			log.info("登录操作, 放行...");
			filterChain.doFilter(request, response);
			return;
		}

		//3. 获取请求头中的令牌（token）。
		String token = request.getHeader("token");

		//4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
		if (token == null || token.isEmpty()) {
			log.info(" 令牌为空,未登录...");
			response.setStatus(401);
			return;
		}

		//5. 解析token，如果解析失败，返回错误结果（未登录）。
		try {
			Claims claims = JwtUtils.parseJWT(token);//解析令牌
			Object id = claims.get("id");//获取员工id
			Integer empId = Integer.valueOf(id.toString());//把id转为int
			CurrentHolder.setCurrentId(empId);//设置当前登录的id
		} catch (Exception e) {
			e.printStackTrace();
			log.info("令牌解析失败，未登录...");
			response.setStatus(401);
			return;
		}

		//6. 放行。
		log.info("令牌校验通过，放行...");
		filterChain.doFilter(request, response);

		//7. 移除当前线程的id
		CurrentHolder.remove();
	}
}

