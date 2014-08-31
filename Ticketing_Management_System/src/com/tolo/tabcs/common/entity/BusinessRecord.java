package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class BusinessRecord implements Serializable {
	private int buss_red_id;//营业记录编号
	private String buss_red_date;//记录日期
	private int user_id;//用户编号
	private int branch_id;//网点编号
	private int buss_red_price;//价格
	private String buss_red_account_state;//营业状态
	private String buss_type;//营业类型
	private String branch_name;//营业网点
	private String user_name;//用户姓名
	
	public BusinessRecord(){
	}
	
	public int getBuss_red_id() {
		return buss_red_id;
	}
	
	public void setBuss_red_id(int bussRedId) {
		buss_red_id = bussRedId;
	}
	
	public String getBuss_red_date() {
		return buss_red_date;
	}
	
	public void setBuss_red_date(String bussRedDate) {
		buss_red_date = bussRedDate;
	}
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int userId) {
		user_id = userId;
	}
	
	public int getBranch_id() {
		return branch_id;
	}
	
	public void setBranch_id(int branchId) {
		branch_id = branchId;
	}
	
	public int getBuss_red_price() {
		return buss_red_price;
	}
	
	public void setBuss_red_price(int bussRedPrice) {
		buss_red_price = bussRedPrice;
	}
	
	public String getBuss_red_account_state() {
		return buss_red_account_state;
	}
	
	public void setBuss_red_account_state(String bussRedAccountState) {
		buss_red_account_state = bussRedAccountState;
	}
	
	public String getBuss_type() {
		return buss_type;
	}
	
	public void setBuss_type(String bussType) {
		buss_type = bussType;
	}
	
	public String getBranch_name() {
		return branch_name;
	}
	
	public void setBranch_name(String branchName) {
		branch_name = branchName;
	}
	
	public String getUser_name() {
		return user_name;
	}
	
	public void setUser_name(String userName) {
		user_name = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + buss_red_id;
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
		BusinessRecord other = (BusinessRecord) obj;
		if (buss_red_id != other.buss_red_id)
			return false;
		return true;
	}

}
