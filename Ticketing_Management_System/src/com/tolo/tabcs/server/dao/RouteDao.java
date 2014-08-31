package com.tolo.tabcs.server.dao;

public interface RouteDao {
	
	public String[] findPlaceByRouteId(int routeId);

	public Integer[] searchAllRouteId();
	public int findOilFuel(int flightairline);	
}
