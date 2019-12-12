package com.spring.statecity;

public class statebn {
	public statebn() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int st_id;
	private String st_name;
	private String st_code;
	
	public int getSt_id() {
		return st_id;
	}
	public void setSt_id(int st_id) {
		this.st_id = st_id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_code() {
		return st_code;
	}
	public void setSt_code(String st_code) {
		this.st_code = st_code;
	}
	@Override
	public String toString() {
		return "/n [st_id=" + st_id + ", st_name=" + st_name + ", st_code=" + st_code + "]";
	}
	public statebn(int st_id, String st_name, String st_code) {
		super();
		this.st_id = st_id;
		this.st_name = st_name;
		this.st_code = st_code;
	}
	
	
	
	

}
