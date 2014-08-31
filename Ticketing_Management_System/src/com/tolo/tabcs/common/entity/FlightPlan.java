package com.tolo.tabcs.common.entity;

import java.io.Serializable;
import java.util.Date;

	public class FlightPlan implements Serializable{
	private int fp_id;//航班计划编号
	private String flight_num;//航班号
	private Date fp_start_date;//计划开始日期
	private Date fp_end_date;//计划结束日期
	private int route_id;//航线编号
	private String fp_departure_Date;//离港时间
	private String fp_arrival_Date;//到港时间
	private int fp_scheduler;//航班班期
	private int fp_base_price;//航班计划基准票价
	private double fp_season_discount;//经济舱季节折扣
	private double plane_id;//飞机机型编号
	// yyyy-MM-dd hh:mm:ss
	public FlightPlan() {
		
	}
	
	@Override
		public String toString() {
			return fp_id+" "+flight_num+" "+fp_start_date+" "+fp_end_date+" "+
			route_id+" "+fp_departure_Date+" "+fp_arrival_Date+" "+fp_season_discount;
		}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fp_id;
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
		FlightPlan other = (FlightPlan) obj;
		if (fp_id != other.fp_id)
			return false;
		return true;
	}
	public int getFp_id() {
		return fp_id;
	}
	public void setFp_id(int fpId) {
		fp_id = fpId;
	}
	public String getFlight_num() {
		return flight_num;
	}
	public void setFlight_num(String flightNum) {
		flight_num = flightNum;
	}
	public Date getFp_start_date() {
		return fp_start_date;
	}
	public void setFp_start_date(Date fpStartDate) {
		fp_start_date = fpStartDate;
	}
	public Date getFp_end_date() {
		return fp_end_date;
	}
	public void setFp_end_date(Date fpEndDate) {
		fp_end_date = fpEndDate;
	}
	public int getRoute_id() {
		return route_id;
	}
	public void setRoute_id(int routeId) {
		route_id = routeId;
	}
	public String getFp_departure_Date() {
		return fp_departure_Date;
	}
	public void setFp_departure_Date(String fpDepartureDate) {
		fp_departure_Date = fpDepartureDate;
	}
	public String getFp_arrival_Date() {
		return fp_arrival_Date;
	}
	public void setFp_arrival_Date(String fpArrivalDate) {
		fp_arrival_Date = fpArrivalDate;
	}
	public int getFp_scheduler() {
		return fp_scheduler;
	}
	public void setFp_scheduler(int fpScheduler) {
		fp_scheduler = fpScheduler;
	}
	public int getFp_base_price() {
		return fp_base_price;
	}
	public void setFp_base_price(int fpBasePrice) {
		fp_base_price = fpBasePrice;
	}
	public double getFp_season_discount() {
		return fp_season_discount;
	}
	public void setFp_season_discount(double fpSeasonDiscount) {
		fp_season_discount = fpSeasonDiscount;
	}
}
