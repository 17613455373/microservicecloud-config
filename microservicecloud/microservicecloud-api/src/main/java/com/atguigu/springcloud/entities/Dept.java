package com.atguigu.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 实体类
 * @author 
 *
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {//必须序列化
	
	private Long deptno;//主键
	private String dname;//部门名称
	private String db_source;//数据库名称
	

	/*
	 * public static void main(String[] args) { Dept dept = new Dept();
	 * dept.setDeptno(11L).setDname("").setDb_source("");//链式添加值 }
	 */
}
