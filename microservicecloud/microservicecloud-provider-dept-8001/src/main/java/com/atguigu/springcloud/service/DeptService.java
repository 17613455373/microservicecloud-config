package com.atguigu.springcloud.service;

import java.util.List;

import com.atguigu.springcloud.entities.Dept;

public interface DeptService {
	Dept findById(Long id);
	List<Dept> findAll();
	Integer addDept(Dept dept);
}
