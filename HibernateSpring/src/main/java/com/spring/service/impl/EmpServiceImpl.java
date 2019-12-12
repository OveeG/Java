package com.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.beans.Employee;
import com.spring.dao.EmpDao;
import com.spring.entities.EmployeeEntity;
import com.spring.service.EmpService;

@Service("service")
public class EmpServiceImpl implements EmpService  {
	@Autowired
	public EmpDao empdao;

	public int addEmployee(Employee emp) {
		if(emp!=null) {
			//Employee empen=new EmployeeEntity(convertToPojo());
		
			return empdao.addEmployee(convertToEntity(emp));
		
		
		}
		return 0;
	}

	private EmployeeEntity convertToEntity(Employee emp) {
		EmployeeEntity empt = new EmployeeEntity();
		empt.setEmp_id(emp.getEmp_id());
		empt.setEmp_name(emp.getEmp_name());
		return empt;
	}
	private Employee convertToPojo(EmployeeEntity empent) {
		Employee emp= new Employee();
		emp.setEmp_id(empent.getEmp_id());
		emp.setEmp_name(empent.getEmp_name());

		return emp;
	}

	public Employee getEmployee(int empId) {
		if(empId>0) {
			EmployeeEntity empent= empdao.getEmployee(empId);
			if(empent==null) {
				System.out.println("No record Found with Employee Id"+empId);
			}
			return convertToPojo(empent);
			
		}
		System.out.println("Enter correct Employee Id");
		return null;
	}

	public List<Employee> getAllEmployee() {
		List<EmployeeEntity> empen=empdao.getAllEmployee();

		return convertToPojos(empen);

	}

	private List<Employee> convertToPojos(List<EmployeeEntity> empent){
		List<Employee> empbean=new ArrayList<Employee>();
		for(EmployeeEntity e:empent) {
			empbean.add(convertToPojo(e));
		}

		return empbean;


	}

	public String deleteEmployee(int empId) {
		Employee bean=getEmployee(empId);
		if(empId>0) {
			return empdao.deleteEmployee(convertToEntity(bean));
		}
		System.out.println("Please Enter correct EmployeeId");		
		return null;


	}

	public Employee updateEmployee(Employee emp) {
		if(emp!=null) {
			System.out.println("inside empserviceimpl");
			Employee bean=getEmployee(emp.getEmp_id());
			System.out.println(bean);
			EmployeeEntity entity= empdao.updateEmployee(convertToEntity(emp));
			return convertToPojo(entity);
			
		}
		return null;
	}
}
