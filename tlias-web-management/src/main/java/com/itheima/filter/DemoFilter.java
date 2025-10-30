package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

//过滤器
@Slf4j
//@WebFilter(urlPatterns = "/*")//配置过滤器要拦截的请求路径（ /* 表示拦截浏览器的所有请求 ）
public class DemoFilter implements Filter {
	//初始化方法, web服务器启动, 创建Filter实例时调用, 只调用一次
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		log.info("初始化方法");
	}

	//拦截到请求时,调用该方法,可以调用多次
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

		log.info("拦截到请求,调用该方法");
		filterChain.doFilter(servletRequest, servletResponse);//放行
	}

	//销毁方法, web服务器关闭时调用, 只调用一次
	@Override
	public void destroy() {
		Filter.super.destroy();
		log.info("销毁方法");
	}
}
