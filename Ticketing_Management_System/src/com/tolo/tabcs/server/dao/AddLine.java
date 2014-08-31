package com.tolo.tabcs.server.dao;

import com.tolo.tabcs.common.entity.Route;

public interface AddLine {
	
	int[] getAirportId(Route route);
	
	String insertLine(Route route);
	
}
