package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class MemberFlightRecoder implements Serializable {
	private int sta_id;//会员航程编号
	private int meb_id;//会员编号
	private String sta_from_airport;//航程出发地机场
	private String sta_to_airport;//航程目的地机场
	private String sta_from_date;//航程出发日期
	private String sta_flight_num;//航班号
	private String sta_cabin_class;//航程舱位
	private int sta_account_mileage;//航程统计里程
	
	public MemberFlightRecoder() {
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sta_id;
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
		MemberFlightRecoder other = (MemberFlightRecoder) obj;
		if (sta_id != other.sta_id)
			return false;
		return true;
	}
	public int getSta_id() {
		return sta_id;
	}
	public void setSta_id(int staId) {
		sta_id = staId;
	}
	public int getMeb_id() {
		return meb_id;
	}
	public void setMeb_id(int mebId) {
		meb_id = mebId;
	}
	public String getSta_from_airport() {
		return sta_from_airport;
	}
	public void setSta_from_airport(String staFromAirport) {
		sta_from_airport = staFromAirport;
	}
	public String getSta_to_airport() {
		return sta_to_airport;
	}
	public void setSta_to_airport(String staToAirport) {
		sta_to_airport = staToAirport;
	}
	public String getSta_from_date() {
		return sta_from_date;
	}
	public void setSta_from_date(String staFromDate) {
		sta_from_date = staFromDate;
	}
	public String getSta_flight_num() {
		return sta_flight_num;
	}
	public void setSta_flight_num(String staFlightNum) {
		sta_flight_num = staFlightNum;
	}
	public String getSta_cabin_class() {
		return sta_cabin_class;
	}
	public void setSta_cabin_class(String staCabinClass) {
		sta_cabin_class = staCabinClass;
	}
	public int getSta_account_mileage() {
		return sta_account_mileage;
	}
	public void setSta_account_mileage(int staAccountMileage) {
		sta_account_mileage = staAccountMileage;
	}
}
