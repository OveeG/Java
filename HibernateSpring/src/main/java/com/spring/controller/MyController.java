package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.Employee;
import com.spring.service.impl.EmpServiceImpl;
import com.spring.util.Generic;

@RestController
public class MyController {


	@Autowired
	EmpServiceImpl service;


	@RequestMapping(value = "/",method = RequestMethod.POST)
	public ResponseEntity<?> addEmp(@RequestBody Employee bean) {
		int id=service.addEmployee(bean);
		if(id>0) {
		return new ResponseEntity(new Generic(111, "We are performing Git"),HttpStatus.OK); 
	}
		else {
			return new ResponseEntity(new Generic(1000, "Git  Failed"),HttpStatus.OK);
		}
	}

}
