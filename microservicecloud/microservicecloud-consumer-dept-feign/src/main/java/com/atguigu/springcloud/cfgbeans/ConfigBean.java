package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

@Configuration
public class ConfigBean {

	/**
	 * Ribbon的默认算法
	 * @return
	 */
	@Bean
	@LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端  负载均衡工具 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	/**
	 * 内置的配置算法类
	 * 改变为其他的算法,达到的目的是用我们重新选择的随机算法替代默认的轮询
	 * @return
	 */
	@Bean
	public IRule myIRule() {
		return new RoundRobinRule();
	}
}
