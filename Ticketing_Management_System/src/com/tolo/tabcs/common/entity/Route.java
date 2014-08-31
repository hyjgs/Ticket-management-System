package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Route implements Serializable {
	private int route_id;// 航线编号 1
	private int from_airport_id;// 出发机场编号
	private int to_airport_id;// 到达机场编号
	private int route_distance;// 航线距离 4
	private int route_base_price;// 基准票价
	private int flight_num_pre_week;// 该航线上每周的航班数
	private int oil_tax;// 燃油税

	private String from_airport_name; // 2
	private String to_airport_name; // 3

	private String from_city_name; // 2
	private String to_city_name; // 3

	public Route() {

	}

	public Route(int routeId) {
		super();
		route_id = routeId;
	}

	public Route(int routeId, int routeDistance) {
		super();
		route_id = routeId;
		route_distance = routeDistance;
	}

	public Route(String from_city_name, String to_city_name) {
		super();
		this.from_city_name = from_city_name;
		this.to_city_name = to_city_name;
	}

	public Route(int routeId, String fromAirportName, String toAirportName,
			int routeDistance) {
		super();
		route_id = routeId;
		route_distance = routeDistance;
		from_airport_name = fromAirportName;
		to_airport_name = toAirportName;
	}

	public int getRoute_id() {
		return route_id;
	}

	public void setRoute_id(int routeId) {
		route_id = routeId;
	}

	public int getFrom_airport_id() {
		return from_airport_id;
	}

	public void setFrom_airport_id(int fromAirportId) {
		from_airport_id = fromAirportId;
	}

	public int getTo_airport_id() {
		return to_airport_id;
	}

	public void setTo_airport_id(int toAirportId) {
		to_airport_id = toAirportId;
	}

	public int getRoute_distance() {
		return route_distance;
	}

	public void setRoute_distance(int routeDistance) {
		route_distance = routeDistance;
	}

	public int getRoute_base_price() {
		return route_base_price;
	}

	public void setRoute_base_price(int routeBasePrice) {
		route_base_price = routeBasePrice;
	}

	public int getFlight_num_pre_week() {
		return flight_num_pre_week;
	}

	public void setFlight_num_pre_week(int flightNumPreWeek) {
		flight_num_pre_week = flightNumPreWeek;
	}

	public int getOil_tax() {
		return oil_tax;
	}

	public void setOil_tax(int oilTax) {
		oil_tax = oilTax;
	}

	public String getFrom_airport_name() {
		return from_airport_name;
	}

	public void setFrom_airport_name(String fromAirportName) {
		from_airport_name = fromAirportName;
	}

	public String getTo_airport_name() {
		return to_airport_name;
	}

	public void setTo_airport_name(String toAirportName) {
		to_airport_name = toAirportName;
	}

	public String getFrom_city_name() {
		return from_city_name;
	}

	public void setFrom_city_name(String fromCityName) {
		from_city_name = fromCityName;
	}

	public String getTo_city_name() {
		return to_city_name;
	}

	public void setTo_city_name(String toCityName) {
		to_city_name = toCityName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + route_id;
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
		Route other = (Route) obj;
		if (route_id != other.route_id)
			return false;
		return true;
	}
	/*
	 * public String getRoute_id() { // TODO Auto-generated method stub return
	 * null; }
	 */

}
