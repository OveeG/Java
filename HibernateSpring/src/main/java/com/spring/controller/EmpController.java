package com.spring.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.beans.Employee;
import com.spring.service.impl.EmpServiceImpl;
import com.spring.util.Generic;

@RestController
@RequestMapping(value ="/employee")
public class EmpController {

	@Autowired
	EmpServiceImpl service;

	@RequestMapping(value = "/",method = RequestMethod.POST)
	public ResponseEntity addEmp(@RequestBody Employee bean) {
		int id=service.addEmployee(bean);
		if(id>0) {
		return new ResponseEntity(new Generic(111, "Added successfully"),HttpStatus.OK); 
	}
		else {
			return new ResponseEntity(new Generic(1000, "Failed"),HttpStatus.OK);
		}
	}

	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee(); 
	}
	
	@RequestMapping(value="/{emp_id}",method=RequestMethod.GET)
	public ResponseEntity getEmployee(@PathVariable("emp_id") int emp_id) {
	return new ResponseEntity(service.getEmployee(emp_id), HttpStatus.OK);
	}

	@RequestMapping(value = "/{emp_id}",method=RequestMethod.DELETE)
	public ResponseEntity empdelete(@PathVariable("emp_id") int empId) {
		return new ResponseEntity(service.deleteEmployee(empId), HttpStatus.OK);
	}

	@RequestMapping(value="/{emp_id}",method=RequestMethod.PUT)
	public ResponseEntity empupdate(@RequestBody Employee emp,@PathVariable("emp_id") int emp_id) {

		Employee employee=service.updateEmployee(emp);
		if(employee==null) 
			return new ResponseEntity(new Generic(1111, "fail to update"), HttpStatus.OK);	
		
		return new ResponseEntity(new Generic(1111, "updated"), HttpStatus.OK);

	}

}

