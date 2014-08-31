package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Clerk implements Serializable {
	private int branch_id;//网点编号
	private String branch_name;//网点名称
	private String province_name;//省份
	private String city_name;//城市
	private String branch_address;//网点地址
	private String telephone;//电话
	private int user_id;//用户编号
	
	public Clerk(){
		
	}
	
	public int getBranch_id() {
		return branch_id;
	}
	
	public void setBranch_id(int branchId) {
		branch_id = branchId;
	}
	
	public String getBranch_name() {
		return branch_name;
	}
	
	public void setBranch_name(String branchName) {
		branch_name = branchName;
	}
	
	public String getProvince_name() {
		return province_name;
	}
	
	public void setProvince_name(String provinceName) {
		province_name = provinceName;
	}
	
	public String getCity_name() {
		return city_name;
	}
	
	public void setCity_name(String cityName) {
		city_name = cityName;
	}
	
	public String getBranch_address() {
		return branch_address;
	}
	
	public void setBranch_address(String branchAddress) {
		branch_address = branchAddress;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int userId) {
		user_id = userId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branch_id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clerk other = (Clerk) obj;
		if (branch_id != other.branch_id)
			return false;
		return true;
	}
}
