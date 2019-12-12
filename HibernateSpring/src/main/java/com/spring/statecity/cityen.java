package com.spring.statecity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class cityen {

	@Id
	private int c_id;
	private String c_name;
	private int c_pincode;
	private String active;
	
	
	@JoinTable(
			name = "StateCity",
			joinColumns  = @JoinColumn(
					name = "c_id",unique=true,
					referencedColumnName = "c_id"
					),
			inverseJoinColumns = @JoinColumn(
					name = "st_id",
					referencedColumnName = "st_id"
					)

			)
	@ManyToOne
	private stateen sten;

   
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}

	public cityen(int c_id, String c_name, int c_pincode, String active, stateen sten) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_pincode = c_pincode;
		this.active = active;
		this.sten = sten;
	}
	
	public stateen getSten() {
		return sten;
	}
	public void setSten(stateen sten) {
		this.sten = sten;
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
		return "cityen [c_id=" + c_id + ", c_name=" + c_name + ", c_pincode=" + c_pincode + ", active=" + active
				+ ", sten=" + sten + "]";
	}
	public cityen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
