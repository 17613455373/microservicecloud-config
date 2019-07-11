package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;
import com.atguigu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class DeptController {
	@Autowired
	DeptService deptService;
	//	@Autowired
	//	DiscoveryClient client;

	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法（也就是下面那个方法）
	public Dept get(@PathVariable("id")Long id) {
		Dept dept =  deptService.findById(id);
		if(null == dept) {//这是在方法内部自己抛出异常
			//上面的注解，在发生异常的时候会掉用下面的的方法，并返回到服务响应中
			//后续的服务依赖自动断掉
			throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		}
		return dept;
	}
	/**
	 * 处理服务熔断
	 * @param id
	 * @return
	 */
	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id)
				.setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
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
