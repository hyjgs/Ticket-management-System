package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchFlightPlanByidAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String flightNum = (String)req.getData("flight_num");
		FlightPlanDao fpDao = (FlightPlanDao)DAOFactory.getInstance(FlightPlanDao.class);
		List<FlightPlan> fPlan = fpDao.getFlightPlanMessageByid(flightNum);
//		System.out.println(fPlan+":length "+fPlan.size());
		res.addData("flightPlan", fPlan);
	}

}
