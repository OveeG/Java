package com.spring.dao;

import java.util.List;

import com.spring.entities.EmployeeEntity;

public interface EmpDao {
	public int addEmployee(EmployeeEntity emp);
	public EmployeeEntity getEmployee(int empId);
	public List<EmployeeEntity> getAllEmployee();
	public String deleteEmployee(EmployeeEntity entity);
	public EmployeeEntity updateEmployee(EmployeeEntity emp);
	/*public Employee getEmployee(Employee emp);
	public List<Employee> getAllEmployee();
	public Employee updateEmployee(Employee emp);
	public String deleteEmployee(int empId);*/
}
