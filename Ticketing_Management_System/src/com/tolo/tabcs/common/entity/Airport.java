package com.tolo.tabcs.common.entity;

import java.io.Serializable;
/**
 * 飞机实体类
 * @author ht
 *
 */
public class Airport implements Serializable{

	private int id;//机场编号
	private String airport_name;//机场名称
	private int province_id;//机场省份ID
	private int city_id;//机场城市ID
	private String airport_full_name;//机场完整名称
	private String airport_code;//机场三字码
	private int departure_routes_num;//出发航线条数
	private int arrival_routes_num;//到达航线条数
	private String airport_grand;//机场等级
	private int departure_flight_num_pre_week;//每周离港航班数
	private int arrival_flight_num_pre_week;//每周到港航班数
	private String province_name;//省份名称
	private String city_name;//城市名称
	
	public Airport(){
		
	}

	public Airport(String airport_code, String airportName,String airport_full_name, String cityName,String provinceName) {
		super();
		this.airport_code = airport_code;
		airport_name = airportName;
		this.airport_full_name=airport_full_name;
		province_name = provinceName;
		city_name = cityName;
	}

	public Airport(int id, String airportName) {
		super();
		this.id = id;
		airport_name = airportName;
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

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAirport_name() {
		return airport_name;
	}
	
	public void setAirport_name(String airportName) {
		airport_name = airportName;
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
	
	public String getAirport_full_name() {
		return airport_full_name;
	}
	
	public void setAirport_full_name(String airportFullName) {
		airport_full_name = airportFullName;
	}
	
	public String getAirport_code() {
		return airport_code;
	}
	
	public void setAirport_code(String airportCode) {
		airport_code = airportCode;
	}
	
	public int getDeparture_routes_num() {
		return departure_routes_num;
	}
	
	public void setDeparture_routes_num(int departureRoutesNum) {
		departure_routes_num = departureRoutesNum;
	}
	public int getArrival_routes_num() {
		return arrival_routes_num;
	}
	
	public void setArrival_routes_num(int arrivalRoutesNum) {
		arrival_routes_num = arrivalRoutesNum;
	}
	
	public String getAirport_grand() {
		return airport_grand;
	}
	
	public void setAirport_grand(String airportGrand) {
		airport_grand = airportGrand;
	}
	
	public int getDeparture_flight_num_pre_week() {
		return departure_flight_num_pre_week;
	}
	
	public void setDeparture_flight_num_pre_week(int departureFlightNumPreWeek) {
		departure_flight_num_pre_week = departureFlightNumPreWeek;
	}
	
	public int getArrival_flight_num_pre_week() {
		return arrival_flight_num_pre_week;
	}
	
	public void setArrival_flight_num_pre_week(int arrivalFlightNumPreWeek) {
		arrival_flight_num_pre_week = arrivalFlightNumPreWeek;
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
		if (!(obj instanceof Airport))
			return false;
		Airport other = (Airport) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
