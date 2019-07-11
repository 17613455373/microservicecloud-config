package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;
/**
 * 使用restTemplate访问restful接口
 * (url,requestMap,ResponseBean.class)对应
 * rest请求地址,参数,HTTP响应扎转换成的对象类型
 * @author huitengxian1996
 *
 */
@RestController
public class DeptController_Consumer {
	
	//public static final String REST_URL_PREFIX="http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/dept/add")
	public Integer add(Dept dept) {
		
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Integer.class);
	}
	@RequestMapping("/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id")Long id) {
		
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/consumer/dept/list")
	public List<Dept> list(Dept dept) {
		
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
	}
	//测试@EnableiscoveryClient,消费端可以调用服务发现
//    @GetMapping(value="/consumer/dept/discovery")
//    public Object discovery() {
//    	return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
//    }
}
