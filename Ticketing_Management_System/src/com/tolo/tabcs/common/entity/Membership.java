package com.tolo.tabcs.common.entity;

public class Membership {
	  private int id;//会员编号
	  private int mem_card_num;//会员卡号
	  private String  password;//会员密码
	  private String  name;//会员姓名（中文）
	  private String spname;//会员姓名（拼音）
	  private String gender;//性别
	  private String birthday;//会员生日
	  private String certif_type;//证件类型
	  private String certif_num;//证件号码
	  private String tel_num1;//电话1
	  private String tel_num2;//电话2
	  private String address;//会员地址
	  private String memb_zib;//会员邮编
	  private String reg_date;//会员注册日期
	  private String email;//会员邮箱
	  private String rank;//会员等级
	  private int account_stage;//会员累计航段
	  private int account_mileage;//会员累计里程
	 
	  public Membership(){
		  
	  }
	
	public Membership(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMem_card_num() {
		return mem_card_num;
	}
	
	public void setMem_card_num(int memCardNum) {
		mem_card_num = memCardNum;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
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
	
	public String getTel_num1() {
		return tel_num1;
	}
	
	public void setTel_num1(String telNum1) {
		tel_num1 = telNum1;
	}
	
	public String getTel_num2() {
		return tel_num2;
	}
	
	public void setTel_num2(String telNum2) {
		tel_num2 = telNum2;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getMemb_zib() {
		return memb_zib;
	}
	
	public void setMemb_zib(String membZib) {
		memb_zib = membZib;
	}
	
	public String getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(String regDate) {
		reg_date = regDate;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public int getAccount_stage() {
		return account_stage;
	}
	
	public void setAccount_stage(int accountStage) {
		account_stage = accountStage;
	}
	
	public int getAccount_mileage() {
		return account_mileage;
	}
	
	public void setAccount_mileage(int accountMileage) {
		account_mileage = accountMileage;
	}
	
	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
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
		if (!(obj instanceof Membership))
			return false;
		Membership other = (Membership) obj;
		if (id != other.id)
			return false;
		return true;
	}
  
}



