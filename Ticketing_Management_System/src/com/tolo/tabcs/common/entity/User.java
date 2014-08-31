package com.tolo.tabcs.common.entity;

import java.io.Serializable;


public class User implements Serializable {
	private int id;//用户编号
	private String name;//用户帐号
	private String pwd;//用户密码
	private String user_name;//用户真实姓名
	private String user_telephone;//用户联系电话
	private String user_certif_type;//证件类型
	private String user_certif_num;//证件号码
	private String email;//用户邮箱
	private String creation_date;//用户创建时间
	private String last_login_time;//最后登录时间
	private int total_login_times;//累计登录次数
	private int  total_login_seconds;//累计登录时长
	private String  user_ref_passenger_id;//关联乘客ID
	private int role_id;//关联角色ID
	private int branch_id;//所属网点编号
	private int  temp_privilege;//临时权限
	private String role_name;//角色名称
	private String branch_name;//网点名称
	private String city_name;//城市名称
	private String privince_name;//省份名称
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String roleName) {
		role_name = roleName;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branchName) {
		branch_name = branchName;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String cityName) {
		city_name = cityName;
	}

	public String getPrivince_name() {
		return privince_name;
	}

	public void setPrivince_name(String privinceName) {
		privince_name = privinceName;
	}

	public User() {
		super();
	}

	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getUser_telephone() {
		return user_telephone;
	}

	public void setUser_telephone(String userTelephone) {
		user_telephone = userTelephone;
	}

	public String getUser_certif_type() {
		return user_certif_type;
	}

	public void setUser_certif_type(String userCertifType) {
		user_certif_type = userCertifType;
	}

	public String getUser_certif_num() {
		return user_certif_num;
	}

	public void setUser_certif_num(String userCertifNum) {
		user_certif_num = userCertifNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creationDate) {
		creation_date = creationDate;
	}

	public String getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(String lastLoginTime) {
		last_login_time = lastLoginTime;
	}

	public int getTotal_login_times() {
		return total_login_times;
	}

	public void setTotal_login_times(int totalLoginTimes) {
		total_login_times = totalLoginTimes;
	}

	public int getTotal_login_seconds() {
		return total_login_seconds;
	}

	public void setTotal_login_seconds(int totalLoginSeconds) {
		total_login_seconds = totalLoginSeconds;
	}

	public String getUser_ref_passenger_id() {
		return user_ref_passenger_id;
	}

	public void setUser_ref_passenger_id(String userRefPassengerId) {
		user_ref_passenger_id = userRefPassengerId;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int roleId) {
		role_id = roleId;
	}

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branchId) {
		branch_id = branchId;
	}

	public int getTemp_privilege() {
		return temp_privilege;
	}

	public void setTemp_privilege(int tempPrivilege) {
		temp_privilege = tempPrivilege;
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
	if(obj instanceof User){
		User u = (User)obj;
		return u.id==this.id;
	}
	return false;
	}
	
}
