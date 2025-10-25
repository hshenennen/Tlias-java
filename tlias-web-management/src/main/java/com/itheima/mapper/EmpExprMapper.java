package com.itheima.mapper;

import com.itheima.pojo.EmpExpr;
import com.itheima.pojo.EmpLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工经历
 */
@Mapper
public interface EmpExprMapper {
	//添加员工 -- 经历
	void insertBatch(List<EmpExpr> exprList);

	//删除员工的经历
	void delete(List<Integer> empId);
}
