package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Ticket implements Serializable {
	private int ticket_id;//机票编号
	private int psg_id;//乘客编号
	private String psg_name;//乘客姓名
	private int flight_num;//飞机编号
	private String sta_from_airport;//出发机场
	private String end_from_airport;//到达机场
	private String ticket_start_date;//出发日期
	//private String sta_fly_date;
	private int seat_number;//座位号
	private int ticket_price;//机票价格
	private int cabin_class_id;//舱位号
	
	private String psg_certif_numl;
	public Ticket(){
		
	}
	public Ticket(int ticketId) {
		super();
		ticket_id = ticketId;
	}
	@Override
	public String toString() {
		return ticket_id+" "+psg_id+" "+psg_name+" "+flight_num+" "+sta_from_airport
		+" "+end_from_airport+" "+ticket_start_date+" "+seat_number+" "+ticket_price+" "+
		cabin_class_id;
	}
	

	public Ticket(int flightNum, String staFromAirport,
			String endFromAirport,String psgName,String psgCertifNuml, String ticketStartDate, int ticketPrice) {
		super();
		flight_num =flightNum;
		psg_name = psgName;
		sta_from_airport = staFromAirport;
		end_from_airport = endFromAirport;
		psg_certif_numl = psgCertifNuml;
		ticket_start_date = ticketStartDate;
		ticket_price = ticketPrice;
	}
	
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticketId) {
		ticket_id = ticketId;
	}
	public int getPsg_id() {
		return psg_id;
	}
	public void setPsg_id(int psgId) {
		psg_id = psgId;
	}
	public String getPsg_name() {
		return psg_name;
	}
	public void setPsg_name(String psgName) {
		psg_name = psgName;
	}
	public int getFlight_num() {
		return flight_num;
	}
	public void setFlight_num(int flightNum) {
		flight_num = flightNum;
	}
	public String getSta_from_airport() {
		return sta_from_airport;
	}
	public void setSta_from_airport(String staFromAirport) {
		sta_from_airport = staFromAirport;
	}
	public String getEnd_from_airport() {
		return end_from_airport;
	}
	public void setEnd_from_airport(String endFromAirport) {
		end_from_airport = endFromAirport;
	}
	public String getTicket_start_date() {
		return ticket_start_date;
	}
	public void setTicket_start_date(String ticketStartDate) {
		ticket_start_date = ticketStartDate;
	}
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seatNumber) {
		seat_number = seatNumber;
	}
	public int getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(int ticketPrice) {
		ticket_price = ticketPrice;
	}
	public int getCabin_class_id() {
		return cabin_class_id;
	}
	public void setCabin_class_id(int cabinClassId) {
		cabin_class_id = cabinClassId;
	}
	public String getPsg_certif_numl() {
		return psg_certif_numl;
	}
	public void setPsg_certif_numl(String psgCertifNuml) {
		psg_certif_numl = psgCertifNuml;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ticket_id;
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
		Ticket other = (Ticket) obj;
		if (ticket_id != other.ticket_id)
			return false;
		return true;
	}

	
}
