package com.tolo.tabcs.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.server.daoimp.FlightPlanDaoImpl;

public class FlightPlanDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlightPlanDaoImpl d =new FlightPlanDaoImpl();
//		List<FlightPlan> l = new ArrayList<FlightPlan>(d.getFlightPlanMessage("首都机场", "虹桥机场"));
//		System.out.println(l);
////		l.clear();
//		l =d.getFlightPlanMessageByid("TL1202");
//		System.out.println(l);
//		int s = d.getBasePrice(100001);
//		System.out.println(s);
//		FlightPlan f = new FlightPlan();
//		f.setFlight_num("TL1202");
//		f.setFp_scheduler(12);
//		f.setFp_season_discount(0.9);
//		f.setFp_end_date(new Date());
//		f.setFp_start_date(new Date());
//		f.setRoute_id(100001);
//		f.setFp_departure_Date("12:20:12");
//		f.setFp_arrival_Date("18:12:20");
//		boolean a =d.updateFlightPlan(f);
//		System.out.println(a);
		System.out.println(d.findRoutePrice(100007));
//		System.out.println(d.deleteFlightPlan("TL1202"));
	}

}
