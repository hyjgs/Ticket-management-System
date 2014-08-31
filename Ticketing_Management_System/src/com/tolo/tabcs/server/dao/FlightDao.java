package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.Flight;

public interface FlightDao {
	public List<Flight> getFlightMessage(String from_place,String to_place);
	public List<Flight> getFlightMessageByid(String flight_num);
	public boolean updateFlight(Flight f);
	public boolean deleteFlight(String str);
	public boolean addFlight(Flight f);
}
