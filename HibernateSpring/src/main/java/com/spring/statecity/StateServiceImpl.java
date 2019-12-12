package com.spring.statecity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.EmployeeEntity;
@Service("stservice")
public class StateServiceImpl implements StateService {
	@Autowired
	public StateDao sdao;
	@Override
	public String addState(statebn s) {
		if(s!=null) {
			sdao.addState(ConvertToEntity(s));
		}
		return null;
	}
	private stateen ConvertToEntity(statebn s) {
		stateen sten=new stateen();
		sten.setSt_id(s.getSt_id());
		sten.setSt_name(s.getSt_name());
		sten.setSt_code(s.getSt_code());
		return sten;
	}
	@Override
	public List<statebn> getAll() {
		List<stateen> sten=sdao.getAll();
		
		return ConvertToPojos(sten);
	}
	private List<statebn> ConvertToPojos(List<stateen> sten){
		List<statebn> stbn=new ArrayList<statebn>();
		for(stateen e:sten) {
			stbn.add(convertToPojo(e));
		}
		return stbn;
	}
	private statebn convertToPojo(stateen e) {
		statebn stbn=new statebn();
		stbn.setSt_id(e.getSt_id());
		stbn.setSt_code(e.getSt_code());
		stbn.setSt_name(e.getSt_name());
		return stbn;
	}


}
