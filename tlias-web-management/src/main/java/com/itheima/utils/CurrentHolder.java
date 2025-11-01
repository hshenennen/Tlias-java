package com.itheima.utils;

public class CurrentHolder {

	//一次 HTTP 请求通常由一个独立的线程来处理
	private static final ThreadLocal<Integer> CURRENT_LOCAL = new ThreadLocal<>();// 线程本地存储

	public static void setCurrentId(Integer employeeId) {
		CURRENT_LOCAL.set(employeeId);
	}// 设置当前线程的员工id

	public static Integer getCurrentId() {
		return CURRENT_LOCAL.get();
	}// 获取当前线程的员工id

	public static void remove() {
		CURRENT_LOCAL.remove();
	}// 移除当前线程的员工ID
}
