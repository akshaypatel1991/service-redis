package com.redis.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(value = "/callInterceptor", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	   public ResponseEntity<Object> getProduct() {
	      return new ResponseEntity<>("DATA", HttpStatus.OK);
	   }

}
