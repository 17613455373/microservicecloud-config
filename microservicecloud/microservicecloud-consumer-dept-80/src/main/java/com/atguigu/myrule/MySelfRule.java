package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {

	/**
	 * 自定义的算法配置类
	 * @return
	 */
	@Bean
	public IRule myRule()
	{
		//return new RandomRule();//Ribbon默认是轮询，我自定义为随机
		return new RandomRule_Mr_Hui();	//自定义负载算法
	}
}
