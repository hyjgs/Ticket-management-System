package com.tolo.tabcs.common.entity;
import java.io.Serializable;
/**
 * 网点实体类
 * @author hyj
 *
 */
public class Branch implements Serializable {
    private int branch_id;//网点编号
    private String branch_name;//网点名称
    private int province_id;//所属省份编号
    private int city_id;//所在城市编号
    private String branch_telephone1;//网点电话1
    private String branch_telephone2;//网点电话2
    private String branch_fax;//网点传真
    private String branch_address;//网点地址
    private String branch_zip;//网点邮编
    private String brance_type;//网点类型
    private String branch_state;//网点状态
    private String province_name;//省份名称
    private String city_name;//城市名称
    private int user_id;//用户ID
    private int count;//笔数
    private int price;//金额
    //两个构造器
	public Branch(){
    	
    }
	
	public Branch(int branch_id){
		this.branch_id = branch_id;
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
	
	public int getProvince_id() {
		return province_id;
	}
	
	public void setProvince_id(int provinceId) {
		province_id = provinceId;
	}
	
	public int getCity_id() {
		return city_id;
	}
	
	public void setCity_id(int cityId) {
		city_id = cityId;
	}
	public String getBranch_telephone1() {
		return branch_telephone1;
	}
	
	public void setBranch_telephone1(String branchTelephone1) {
		branch_telephone1 = branchTelephone1;
	}
	
	public String getBranch_telephone2() {
		return branch_telephone2;
	}
	
	public void setBranch_telephone2(String branchTelephone2) {
		branch_telephone2 = branchTelephone2;
	}
	
	public String getBranch_fax() {
		return branch_fax;
	}
	
	public void setBranch_fax(String branchFax) {
		branch_fax = branchFax;
	}
	
	public String getBranch_address() {
		return branch_address;
	}
	
	public void setBranch_address(String branchAddress) {
		branch_address = branchAddress;
	}
	
	public String getBranch_zip() {
		return branch_zip;
	}
	
	public void setBranch_zip(String branchZip) {
		branch_zip = branchZip;
	}
	
	public String getBrance_type() {
		return brance_type;
	}
	
	public void setBrance_type(String branceType) {
		brance_type = branceType;
	}
	
	public String getBranch_state() {
		return branch_state;
	}
	
	public void setBranch_state(String branchState) {
		branch_state = branchState;
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
	
	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int userId) {
		user_id = userId;
	}
	
	public int getCount() {
			return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
		Branch other = (Branch) obj;
		if (branch_id != other.branch_id)
			return false;
		return true;
		}
		
		@Override
	public String toString() {
		return "Branch [brance_type=" + brance_type + ", branch_address="
				+ branch_address + ", branch_fax=" + branch_fax
				+ ", branch_id=" + branch_id + ", branch_name=" + branch_name
				+ ", branch_state=" + branch_state + ", branch_telephone1="
				+ branch_telephone1 + ", branch_telephone2="
				+ branch_telephone2 + ", branch_zip=" + branch_zip
				+ ", city_id=" + city_id + ", city_name=" + city_name
				+ ", count=" + count + ", price=" + price + ", province_id="
				+ province_id + ", province_name=" + province_name
				+ ", user_id=" + user_id + "]";
	}
	
	
}
