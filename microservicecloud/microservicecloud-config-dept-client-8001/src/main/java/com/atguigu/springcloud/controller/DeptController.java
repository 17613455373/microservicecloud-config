package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	DeptService deptService;
	@Autowired
	DiscoveryClient client;

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id")Long id) {
		return deptService.findById(id);
	}

	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptService.findAll();
	}

	@PostMapping("/dept/add")
	public Integer add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}
	/**
	 * 服务信息展示,这是微服务提供者自己调用自己，看能不能通，能的话才能对外暴露
	 * @return
	 */
//	@GetMapping(value = "/dept/discovery")
//	public Object doscovery() {
//		List<String> list = client.getServices();
//		System.out.println("************" + list);
//
//		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
//		for (ServiceInstance element : srvList) {
//			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
//					+ element.getUri());
//		}
//		return this.client;
//	}
}
