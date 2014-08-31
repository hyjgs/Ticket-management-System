package com.tolo.tabcs.common.entity;

import java.io.Serializable;

/**
 * @author tarena
 *
 */
public class OrderItem implements Serializable {
	private int order_item_id;//订单项编号
	private int flight_id;//航班编号
	private int passenger_id;//乘客编号
	private String ord_cabin_class;//飞机舱位
	private  int discount;//折扣
	private int ticket_price;//机票价格
	private int append_Tax;//机场建设费
	private int order_belong;//所属订单编号
	
	@Override
	public String toString() {
		return order_item_id+" "+flight_id+" "+passenger_id+" "+ord_cabin_class+" "+discount+" "+ticket_price
		+" "+append_Tax+" "+order_belong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order_item_id;
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
		OrderItem other = (OrderItem) obj;
		if (order_item_id != other.order_item_id)
			return false;
		return true;
	}
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int orderItemId) {
		order_item_id = orderItemId;
	}
	public int getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(int flightId) {
		flight_id = flightId;
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passengerId) {
		passenger_id = passengerId;
	}
	public String getOrd_cabin_class() {
		return ord_cabin_class;
	}
	public void setOrd_cabin_class(String ordCabinClass) {
		ord_cabin_class = ordCabinClass;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(int ticketPrice) {
		ticket_price = ticketPrice;
	}
	public int getAppend_Tax() {
		return append_Tax;
	}
	public void setAppend_Tax(int appendTax) {
		append_Tax = appendTax;
	}
	public int getOrder_belong() {
		return order_belong;
	}
	public void setOrder_belong(int orderBelong) {
		order_belong = orderBelong;
	}
	
	

}
