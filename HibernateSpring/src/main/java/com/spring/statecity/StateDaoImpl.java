package com.spring.statecity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sado")
public class StateDaoImpl implements StateDao {
	@Autowired
	SessionFactory sf;
	Session session=null;
	Transaction tr=null;
	@Override
	public String addState(stateen st) {
		try {
			session=sf.openSession();
			tr=session.beginTransaction();
			session.save(st);
			session.flush();
			tr.commit();
			session.close();
			
			return "Added Successfully";
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
			
		
		return null;
	}
	@Override
	public List<stateen> getAll() {
		try {
			session=sf.openSession();
			tr=session.beginTransaction();
			
		return session.createCriteria(stateen.class).list();
	}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

}
	@Override
	public stateen getstate(int st_id) {
		try {
			session=sf.openSession();
			session.get(stateen.class, st_id);
			session.close();
			session.flush();
			
	}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}