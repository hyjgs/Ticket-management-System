package com.tolo.tabcs.server.dao;

import com.tolo.tabcs.common.entity.Airport;

public interface AddAirport {
	int[] getProviceIdCityId(Airport airport);
	String addAirport(Airport airport);
}
