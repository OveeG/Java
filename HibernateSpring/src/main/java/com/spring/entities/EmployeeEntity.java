package com.spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="employeeinfo")
public class EmployeeEntity {
	@Id
	private int emp_id;
	private String emp_name;
	
	@Override
	public String toString() {
		return "\n [emp_id=" + emp_id + ", emp_name=" + emp_name + "]";
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public EmployeeEntity(int emp_id, String emp_name) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	

}
