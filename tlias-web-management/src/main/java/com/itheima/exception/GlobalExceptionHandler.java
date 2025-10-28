package com.itheima.exception;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.DuplicateFormatFlagsException;

@Slf4j
@RestControllerAdvice  //全局异常处理
public class GlobalExceptionHandler {


	//异常处理
	@ExceptionHandler
	public Result ex(Exception e) {
		log.error("程序出错拿~~", e);
		return Result.error("程序出错拿~~");
	}

	@ExceptionHandler
	public Result handleDuplicateKeyException(DuplicateKeyException e) {
		log.error("有错误", e);
		String message = e.getMessage(); //用于获取异常的详细消息字符串
		int i = message.indexOf("Duplicate entry"); //用于查找某个元素或子字符串首次出现的位置（索引）
		String errMsg = message.substring(i); //用于截取字符串的一部分
		String[] arr = errMsg.split(" "); //根据指定的分隔符（正则表达式）将字符串拆分成多个子字符串，并返回一个 String[] 数组。
		return Result.error(arr[2] + "已存在");

	}

}
