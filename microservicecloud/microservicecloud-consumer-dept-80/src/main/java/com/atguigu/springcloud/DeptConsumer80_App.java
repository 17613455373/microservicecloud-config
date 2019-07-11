
package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.atguigu.myrule.MySelfRule;
@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效(自定义负载均衡开启)
//name为微服务的服务端的spring application name   指定微服务下使用当前自定义的算法
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)//(不能再application的路径下)
public class DeptConsumer80_App{
	
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80_App.class, args);
	}
}