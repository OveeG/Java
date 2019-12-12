package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.spring.beans.Employee;
import com.spring.config.SpringHibernateConfig;
import com.spring.entities.EmployeeEntity;
import com.spring.service.impl.EmpServiceImpl;

public class SpringMain {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringHibernateConfig.class);
		EmpServiceImpl emp=(EmpServiceImpl)context.getBean("service");
		System.out.println(emp.getAllEmployee());

		//Employee e1=new Employee(1,"vaishnavi");
		/*
	
		//System.out.println(emp.addEmployee(e2));
		//System.out.println(emp.getEmployee(1));
		//System.out.println(emp.getAllEmployee());
		//System.out.println(emp.deleteEmployee(2));
		Employee entity=new Employee(1,"Abhijeet");
		System.out.println(emp.updateEmployee(entity));
//		Employee e2=new Employee(2,"Abhijeet");
//		System.out.println(emp.updateEmployee(emp););
		Employee e2=new Employee(10,"Abhijeet");
		System.out.println(emp.updateEmployee(e2));
		System.out.println(emp.deleteEmployee(20));
*/	}
	

}
