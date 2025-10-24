package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@RestController
public class UploadController {

	@PostMapping("/upload")
	public Result upload(String name, Integer age, MultipartFile file) throws IOException {
		log.info("提交的内容 name:{},age:{},文件：{}", name, age, file);
		//获取原始名，名字常常会重复，用UUID可以避免
		//substring() 方法用于截取字符串的一部分，返回一个新的字符串
		String originalFilename = file.getOriginalFilename();//获取原始名

		//获取上传文件的后缀名
		//lastIndexOf 查找指定字符（以 int 表示的 Unicode 值）最后一次出现的索引。
		//substring() 方法用于截取字符串的一部分，返回一个新的字符串
		String lostFilename=originalFilename.substring(originalFilename.lastIndexOf("."));
		String newFilename = UUID.randomUUID().toString()+lostFilename;

		//transferTo 是用于将上传的临时文件保存到指定的目标位置。
		file.transferTo(new File("D:/java/" + newFilename));
		return Result.success();
	}
}
