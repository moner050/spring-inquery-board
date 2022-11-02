package com.fastcampus.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.domain.User;

@RestController
public class RESTController {
	
	// GET : SELECT
	@GetMapping("/bank")
	public User httpGet() { 
		User user = new User();
		user.setId(1);
		user.setUsername("aaa");
		user.setPassword("aaa");
		user.setEmail("aaa@gmail.com");
		return user;
	}

	// POST : INSERT
	@PostMapping("/bank")
	// @ResponseBody : Java 객체 --> JSON으로 변환
	// @RequestBody : JSON --> Java 객체로 변환
	public String httpPost(@RequestBody User user) { 
		return "POST 요청 시, 입력값 : " + user.toString();
	}
	
	// PUT : UPDATE
	@PutMapping("/bank")
	public String httpPut() {
		return "PUT 요청 처리";
	}
	
	// DELETE : DELETE
	@DeleteMapping("/bank")
	public String httpDelete(@RequestParam int id) {
		return "DELETE 요청 시, 입력한 값 : " + id;
	}

}
