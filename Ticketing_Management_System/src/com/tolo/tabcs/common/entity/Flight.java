package com.tolo.tabcs.common.entity;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
	private int flight_id;//航班编号
	private String flight_num;//航班号
	private Date flight_departu_date;//航班出发日期
	private  Date flight_arrival_date;//航班到达日期
	private int route_id;//航线编号
	private int plane_id;//机型编号
	private int f_seats_remain;//头等舱剩余座位
	private int b_seats_remain;//公务舱剩余座位
	private int e_seats_remian;//经济舱剩余座位
	private double lowest_discount_price;//最低折扣票价
	public Flight(){
		
	}
	
	public int getFlight_id() {
		return flight_id;
	}
	
	public void setFlight_id(int flightId) {
		flight_id = flightId;
	}
	
	public String getFlight_num() {
		return flight_num;
	}
	
	public void setFlight_num(String flightNum) {
		flight_num = flightNum;
	}
	
	public Date getFlight_departu_date() {
		return flight_departu_date;
	}
	
	public void setFlight_departu_date(Date flightDepartuDate) {
		flight_departu_date = flightDepartuDate;
	}
	
	public Date getFlight_arrival_date() {
		return flight_arrival_date;
	}
	
	public void setFlight_arrival_date(Date flightArrivalDate) {
		flight_arrival_date = flightArrivalDate;
	}
	
	public int getRoute_id() {
		return route_id;
	}
	
	public void setRoute_id(int routeId) {
		route_id = routeId;
	}
	
	public int getPlane_id() {
		return plane_id;
	}
	
	public void setPlane_id(int planeId) {
		plane_id = planeId;
	}
	
	public int getF_seats_remain() {
		return f_seats_remain;
	}
	
	public void setF_seats_remain(int fSeatsRemain) {
		f_seats_remain = fSeatsRemain;
	}
	
	public int getB_seats_remain() {
		return b_seats_remain;
	}
	
	public void setB_seats_remain(int bSeatsRemain) {
		b_seats_remain = bSeatsRemain;
	}
	
	public int getE_seats_remian() {
		return e_seats_remian;
	}
	
	public void setE_seats_remian(int eSeatsRemian) {
		e_seats_remian = eSeatsRemian;
	}
	
	public double getLowest_discount_price() {
		return lowest_discount_price;
	}
	
	public void setLowest_discount_price(double lowestDiscountPrice) {
		lowest_discount_price = lowestDiscountPrice;
	}
	
	@Override
	public String toString() {
		return flight_id+" "+flight_num+" "+flight_departu_date+" "+flight_arrival_date+" "+route_id+" "
		+plane_id+" "+f_seats_remain+" "+b_seats_remain+" "+e_seats_remian+" "+lowest_discount_price;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flight_id;
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
		Flight other = (Flight) obj;
		if (flight_id != other.flight_id)
			return false;
		return true;
	}

}
