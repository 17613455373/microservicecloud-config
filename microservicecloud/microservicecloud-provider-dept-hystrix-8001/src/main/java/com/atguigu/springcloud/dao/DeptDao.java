package com.atguigu.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.atguigu.springcloud.entities.Dept;

@Mapper
public interface DeptDao {
	
	Dept findById(@Param("deptno")Long deptno);
	List<Dept> findAll();
	Integer addDept(Dept dept);
}
