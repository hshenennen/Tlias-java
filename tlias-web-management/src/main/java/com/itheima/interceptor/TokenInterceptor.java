package com.itheima.interceptor;

import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {
	//目标资源方法执行前执行。
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//1. 获取请求url。
		String url = request.getRequestURI();

		//2. 判断请求url中是否包含login，如果包含，说明是登录操作，放行
        /*		if (url.contains("login")) {
			log.info("登录操作, 放行...");
			return true;
		}*/

		//3. 获取请求头中的令牌（token）。
		String token = request.getHeader("token");

		//4. 判断令牌是否存在，如果不存在，返回错误结果（未登录）
		if (token == null || token.isEmpty()) {
			log.info(" 令牌为空,未登录...");
			response.setStatus(401);
			return false;
		}

		//5. 解析token，如果解析失败，返回错误结果（未登录）。
		try {
			JwtUtils.parseJWT(token);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("令牌解析失败，未登录...");
			response.setStatus(401);
			return false;
		}

		//6. 放行。
		log.info("令牌校验通过，放行...");
		return true;
	}
}
