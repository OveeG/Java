package com.spring.statecity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cityservice")
public class CityServiceImpl implements CityService{

	@Autowired
	CityDao citydao;
	@Autowired
	StateService stsr;
	@Override
	public String addCity(citybn cbn) {
		if(cbn!=null) {
//cityen cen=new cityen(cbn.getC_id(), cbn.getC_name(), cbn.getC_pincode(),)
			citydao.addcity(ConvertToEntity(cbn));
		}
		return null;
	}
	private cityen ConvertToEntity(citybn cbn) {
		cityen cen=new cityen();
		cen.setC_id(cbn.getC_id());
		cen.setC_name(cbn.getC_name());
		cen.setC_pincode(cbn.getC_pincode());
		
		
		
		return cen;
	}
	@Override
	public List<citybn> getAll() {
		List<cityen> cten=citydao.getAll();

		return ConvertToPojos(cten);
	}
	private List<citybn> ConvertToPojos(List<cityen> cten){
		List<citybn> ctbn=new ArrayList<citybn>();
		for(cityen e:cten) {
			ctbn.add(convertToPojo(e));
		}
		return ctbn;
	}
	private citybn convertToPojo(cityen ce) {
		citybn ctbn=new citybn();
		ctbn.setC_id(ce.getC_id());
		ctbn.setC_name(ce.getC_name());
		ctbn.setC_pincode(ce.getC_pincode());
		return ctbn;
		
	}
}
