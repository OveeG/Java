package com.spring.statecity;

public class citybn {
	private int c_id;
	private String c_name;
	private int c_pincode;
	private String state;
	
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_pincode() {
		return c_pincode;
	}
	public void setC_pincode(int c_pincode) {
		this.c_pincode = c_pincode;
	}
	@Override
	public String toString() {
		return "citybn [c_id=" + c_id + ", c_name=" + c_name + ", c_pincode=" + c_pincode + "]";
	}
	public citybn(int c_id, String c_name, int c_pincode) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_pincode = c_pincode;
	}
	public citybn() {
		super();
		// TODO Auto-generated constructor stub
	}
   
    
	
}
