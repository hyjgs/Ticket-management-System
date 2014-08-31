package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Seller implements Serializable {
	private int user_id;//用户编号
	private String name;//姓名
	private String province;//省份
	private String city;//城市
	private String branch_address;//网点地址
	private String telephone;//电话
	private int manager_id;//管理员编号
	private int branch_id;//网点编号
	private String branch_name;//网点名称
	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branchName) {
		branch_name = branchName;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branchId) {
		branch_id = branchId;
	}

	public Seller(){
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_id;
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
		Seller other = (Seller) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int managerId) {
		manager_id = managerId;
	}

	@Override
	public String toString() {
		return "Seller [branch_address=" + branch_address + ", city=" + city
				+ ", manager_id=" + manager_id + ", name=" + name
				+ ", province=" + province + ", telephone=" + telephone
				+ ", user_id=" + user_id + "]";
	}

}
