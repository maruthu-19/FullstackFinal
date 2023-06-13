package com.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="data")
public class AppModel {

	@Id 
	// ID Auto generated 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pid;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public float getLefteye() {
		return lefteye;
	}
	public void setLefteye(float lefteye) {
		this.lefteye = lefteye;
	}
	public float getRighteye() {
		return righteye;
	}
	public void setRighteye(float righteye) {
		this.righteye = righteye;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private String custname;
	private int productid;
	private float lefteye;
	private float righteye;
	private String type;

}
