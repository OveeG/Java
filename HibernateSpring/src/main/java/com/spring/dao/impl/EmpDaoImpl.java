package com.spring.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.spring.dao.EmpDao;
import com.spring.entities.EmployeeEntity;

@Repository("empdao")
public class EmpDaoImpl implements EmpDao {
	@Autowired
	SessionFactory sfactory;

	public SessionFactory getSfactory() {
		return sfactory;
	}

	public void setSfactory(SessionFactory sfactory) {
		this.sfactory = sfactory;
	}

	public int addEmployee(EmployeeEntity emp) {
		Session session =null;
		Transaction tr = null;
		try {
			session =sfactory.openSession();
			tr = session.beginTransaction();
			int id =  (Integer) session.save(emp);
			System.out.println("empsaved successfully...!");
			return id;
		}catch(Exception e) {
			System.out.println("Problem in save...!"+e.getMessage());
			return 0;
		}finally {
			closeResources(session,tr);
		}
		
	}

	private void closeResources(Session session, Transaction tr) {

		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
			session.close();
		}
	}

	public EmployeeEntity getEmployee(int empId) {
		Session session=null;
		Transaction tr=null;
		try {
			session=sfactory.openSession();
			System.out.println("Getting Employee");
			System.out.println(session.get(EmployeeEntity.class, empId));
			return session.get(EmployeeEntity.class, empId);
			
		} catch (Exception e) {

             System.out.println("Problem in fetching the data"+e.getMessage());
             return null;
		}
		finally {
			closeResources(session, tr);
		}
		
	}

	@SuppressWarnings("deprecation")
	public List<EmployeeEntity> getAllEmployee() {
	Session session =null;
	Transaction tr=null;
	try {
		session=sfactory.openSession();
		return session.createCriteria(EmployeeEntity.class).list();
		
	} catch (Exception e) {
		System.out.println("Problem in the Fetching the data"+e.getMessage());
		return null;
	}
	finally {
		closeResources(session, tr);
	}
		
	}

	public String deleteEmployee(EmployeeEntity entity) {
		
		Session session =null;
		Transaction tr = null;
		try {
			session =sfactory.openSession();
			tr = session.beginTransaction();
			session.delete(entity);
		
			return 	"empsaved deleted successfully...!";
		}catch(Exception e) {
			System.out.println("Problem in save...!"+e.getMessage());
			return null;
		}finally {
			closeResources(session,tr);
		}
	}

	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		Session session =null;
		Transaction tr = null;
		try {
			session =sfactory.openSession();
			tr = session.beginTransaction();
			System.out.println("Emp Updated Successfully...!");
			return (EmployeeEntity) session.merge(emp);
		}catch(Exception e) {
			System.out.println("Problem in update...!"+e.getMessage());
			return null;
		}finally {
			closeResources(session,tr);
		}
	}

	


}
