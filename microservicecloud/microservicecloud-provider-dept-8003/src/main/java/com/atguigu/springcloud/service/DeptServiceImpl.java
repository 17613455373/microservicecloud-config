package com.atguigu.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.Dept;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao deptDao;

	@Override
	public Dept findById(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> findAll() {
		return deptDao.findAll();
	}

	@Override
	public Integer addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

}
