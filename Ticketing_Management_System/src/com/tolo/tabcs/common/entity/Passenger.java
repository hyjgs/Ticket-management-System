package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Passenger implements Serializable {
     private int id;//乘客编号
     private String name;//乘客姓名
     private String certif_type;//证件类型
     private String certif_num;//证件号码
     private String telephone;//联系电话
     private String email;//邮箱
     private String psg_type;//乘客类型
     private String memb_id;//关联会员ID
	public Passenger() {
		super();
	}
	public Passenger(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return id+" "+name+" "+certif_type+" "+certif_num+" "+
		telephone+" "+email+" "+psg_type+" "+memb_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertif_type() {
		return certif_type;
	}
	public void setCertif_type(String certifType) {
		certif_type = certifType;
	}
	public String getCertif_num() {
		return certif_num;
	}
	public void setCertif_num(String certifNum) {
		certif_num = certifNum;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPsg_type() {
		return psg_type;
	}
	public void setPsg_type(String psgType) {
		psg_type = psgType;
	}
	public String getMemb_id() {
		return memb_id;
	}
	public void setMemb_id(String membId) {
		memb_id = membId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Passenger))
			return false;
		Passenger other = (Passenger) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
     
}
