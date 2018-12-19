package com.redis.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import redis.clients.jedis.Jedis;

@SpringBootApplication
public class AuthRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthRedisApplication.class, args);
		
		//Connecting to Redis server on localhost 
	      Jedis jedis = new Jedis("localhost"); 
	      System.out.println("Connection to server sucessfully"); 
	      //check whether server is running or not 
	      System.out.println("Server is running: "+jedis.ping());
		
	}

}

