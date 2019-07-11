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
//	@Bean
//	public IRule myIRule() {
//		/**
//		 * 轮询算法(默认的算法,所以不用写 ↑)
//		 */
//		return new RoundRobinRule();
//		/**
//		 * 随机算法
//		 */
//		return new RandomRule();
//		/**
//		 * 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，还有并发的连接数量超过阈值的服务，然后对剩余的服务列表按照轮询策略进行访问
//		 */
//		return new AvailabilityFilteringRule();
//		/**
//		 * 根据平均响应时间计算所有服务的权重，响应时间越快服务权重越大被选中的概率越高。
//		 * 刚启动时如果统计信息不足则使用RoundRobinRule策略，等统计信息足够，会切换到WeightedResponseTimeRule
//		 */ 
//		return new WeightedResponseTimeRule();
//		/**
//		 * 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
//		 * 这个需要注意，RetryRule在正常情况下，也就是说所有的微服务提供者都正常情况下，他的算法跟轮询的算法一毛一样！
//		 * 区别是什么呢？轮询会一直不停的1，2，3，1，2，3，1，2...，
//		 * 而RetryRule这个算法是：比如2号提供者宕机，那么轮询会一直不停的1，2，3，1，2，3...当发现2号宕机会自动跳到下一个，
//		 * 但是它每次走完1都会去获取一下2，发现问题然后再下一个，就是说“不长记性” 
//		 * 而这个RetryRule算法就是“长记性”的算法，“杯弓蛇影”，它前期也会1，2（砰！），3，1，2（砰！），3，...多轮询几次后发现，
//		 * 2号一直宕机，那么之后便不会再去获取它（2号）了，而是会去获取余下健康、可用的服务
//		 */
//		return new RetryRule();
//		/**
//		 * 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务
//		 */
//		return new BestAvailableRule();
//		/**
//		 * 默认规则,复合判断server所在区域的性能和server的可用性选择服务器
//		 */
//		return new ZoneAvoidanceRule();
//	}
}
