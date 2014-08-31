package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Order implements Serializable {
	private int	order_id;//订单编号
	private int user_id;//用户编号
	private double ord_money;//订单金额
	private String order_items;//包含订单项
	private String order_Date;//预订日期
	private String order_state;//订单状态
	
	public Order(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + order_id;
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
		Order other = (Order) obj;
		if (order_id != other.order_id)
			return false;
		return true;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int orderId) {
		order_id = orderId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int userId) {
		user_id = userId;
	}
	public double getOrd_money() {
		return ord_money;
	}
	public void setOrd_money(double ordMoney) {
		ord_money = ordMoney;
	}
	public String getOrder_items() {
		return order_items;
	}
	public void setOrder_items(String orderItems) {
		order_items = orderItems;
	}
	public String getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(String orderDate) {
		order_Date = orderDate;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String orderState) {
		order_state = orderState;
	}
	
	}
