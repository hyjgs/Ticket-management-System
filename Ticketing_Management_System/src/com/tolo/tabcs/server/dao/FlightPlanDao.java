package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.entity.FlightPlan;

public interface FlightPlanDao {
	public List<FlightPlan> getFlightPlanMessage(String from_place,String to_place);
	public List<FlightPlan> getFlightPlanMessageByid(String flight_num);
	public boolean updateFlightPlan(FlightPlan f);
	public boolean deleteFlightPlan(String flight_num);
	public boolean updateSeasonDiscount(String dis,String flightnum);
	public boolean updateBatchDiscount(String dis);
	public boolean addFlightPlan(FlightPlan fp);
}
