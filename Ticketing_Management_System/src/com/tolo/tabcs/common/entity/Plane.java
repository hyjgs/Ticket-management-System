package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Plane implements Serializable {
	private int plane_id;//飞机编号
	private	int plane_num;//机身编号
	private String plane_model;//机型型号
	private String plane_manufacturer;//制造厂商
	private int max_continue_voyage;//最大续航里程
	private int f_cabin_seats;//头等舱座位数
	private int c_cabin_seats;//公务舱座位数
	private int y_cabin_seats;//经济舱座位数
	private int airport_fee;//机场建设费
	
	public Plane() {
		
	}
	@Override
	public String toString() {
		return plane_id+" "+plane_num+" "+plane_model+" "+
		plane_manufacturer+" "+max_continue_voyage+" "+f_cabin_seats+
		" "+c_cabin_seats+" "+y_cabin_seats+" "+airport_fee;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + plane_id;
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
		Plane other = (Plane) obj;
		if (plane_id != other.plane_id)
			return false;
		return true;
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int planeId) {
		plane_id = planeId;
	}
	public int getPlane_num() {
		return plane_num;
	}
	public void setPlane_num(int planeNum) {
		plane_num = planeNum;
	}
	public String getPlane_model() {
		return plane_model;
	}
	public void setPlane_model(String planeModel) {
		plane_model = planeModel;
	}
	public String getPlane_manufacturer() {
		return plane_manufacturer;
	}
	public void setPlane_manufacturer(String planeManufacturer) {
		plane_manufacturer = planeManufacturer;
	}
	public int getMax_continue_voyage() {
		return max_continue_voyage;
	}
	public void setMax_continue_voyage(int maxContinueVoyage) {
		max_continue_voyage = maxContinueVoyage;
	}
	public int getF_cabin_seats() {
		return f_cabin_seats;
	}
	public void setF_cabin_seats(int fCabinSeats) {
		f_cabin_seats = fCabinSeats;
	}
	public int getC_cabin_seats() {
		return c_cabin_seats;
	}
	public void setC_cabin_seats(int cCabinSeats) {
		c_cabin_seats = cCabinSeats;
	}
	public int getY_cabin_seats() {
		return y_cabin_seats;
	}
	public void setY_cabin_seats(int yCabinSeats) {
		y_cabin_seats = yCabinSeats;
	}
	public int getAirport_fee() {
		return airport_fee;
	}
	public void setAirport_fee(int airportFee) {
		airport_fee = airportFee;
	}
	
}
