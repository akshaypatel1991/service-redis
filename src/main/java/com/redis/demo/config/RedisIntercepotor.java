package com.redis.demo.config;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import redis.clients.jedis.Jedis;

public class RedisIntercepotor implements HandlerInterceptor {

	@Value("${spring.redis.host}")
    private String redisHost;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		System.out.println("---------------------------------------"+redisHost);
		System.out.println("Called pre handler interceptor...!");
		System.out.println("---------------------------------------");
		
		//Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis(redisHost); 
	      System.out.println("Connection to server sucessfully"); 
	      
	      //store data in redis list 
//	      jedis.lpush("token", "tk1"); 
//	      jedis.lpush("token", "tk2"); 
//	      jedis.lpush("token", "tk3"); 
	      // Get the stored data and print it 
	      List<String> list = jedis.lrange("token", 0 ,5); 
	      
	      for(int i = 0; i<list.size(); i++) { 
	         System.out.println("Stored string in redis:: "+list.get(i)); 
	      }
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)	throws Exception {
		// TODO Auto-generated method stub
	}
}
