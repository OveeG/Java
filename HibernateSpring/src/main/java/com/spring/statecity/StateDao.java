package com.spring.statecity;

import java.util.List;

public interface StateDao {
	public String addState(stateen st);
	public List<stateen> getAll();
public stateen getstate(int st_id);
}
