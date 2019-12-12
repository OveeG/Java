package com.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.spring.beans.Employee;
import com.spring.entities.EmployeeEntity;


public interface EmpService {

	public int addEmployee(Employee emp);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployee();
	public String deleteEmployee(int empId);
	public Employee updateEmployee(Employee emp );
	/*public Employee getEmployee(int empId);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee emp);
	public String deleteEmployee(int empId);
	*/
	
}
