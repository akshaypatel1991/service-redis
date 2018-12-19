package com.redis.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringConfiguration implements WebMvcConfigurer  {
	
	@Bean
	RedisIntercepotor redisIntercepotor(){
		return new RedisIntercepotor();
	}

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(redisIntercepotor()).addPathPatterns("/**");
	}
	
}
