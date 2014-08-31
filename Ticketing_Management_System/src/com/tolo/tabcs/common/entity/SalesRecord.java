package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class SalesRecord implements Serializable {
	private int buss_red_id;// 营业记录编号
	private String buss_red_date;// 营业记录日期
	private int user_id;// 用户编号
	private int branch_id;// 网点编号
	private int buss_red_price;// 价格
	private String state;// 营业状态
	private String buss_type;// 营业类型

	public SalesRecord() {

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
		SalesRecord other = (SalesRecord) obj;
		if (buss_red_id != other.buss_red_id)
			return false;
		return true;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBuss_type() {
		return buss_type;
	}

	public void setBuss_type(String bussType) {
		buss_type = bussType;
	}

	@Override
	public String toString() {
		return "SalesRecord [branch_id=" + branch_id + ", buss_red_date="
				+ buss_red_date + ", buss_red_id=" + buss_red_id
				+ ", buss_red_price=" + buss_red_price + ", buss_type="
				+ buss_type + ", state=" + state + ", user_id=" + user_id + "]";
	}

}
