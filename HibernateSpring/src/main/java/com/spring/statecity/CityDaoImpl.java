package com.spring.statecity;

import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("citydao")
public class CityDaoImpl implements CityDao{

	@Autowired
	StateDaoImpl sdao;
	@Autowired
	SessionFactory sf;
	
	Session session=null;
	Transaction tr=null;

	@Override
	public String addcity(cityen cen) {
		try {
			if(cen!=null) {
		citybn cbn=new citybn();		
cityen cityen=new cityen(cen.getC_id(), cen.getC_name(), cen.getC_pincode(), "Y", sdao.getstate(Integer.parseInt(cbn.getState())));
				session=sf.openSession();
				tr=session.beginTransaction();
				session.save(cityen);
			}
		} catch (Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
		finally {
			closeResource(session,tr);
			
		}
		return null;
	}

	private void closeResource(Session session, Transaction tr) {
		if(session!=null) {
			if(tr!=null) {
				session.flush();
				tr.commit();
			}
		}
		session.close();
		
	}

	@Override
	public List<cityen> getAll() {
		try {
			
			session=sf.openSession();
			tr=session.beginTransaction();
			
		return session.createCriteria(cityen.class).list();
	}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


}
