package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class AddFlightSchAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		FlightPlan fp =(FlightPlan)req.getData("flightPlan");
		FlightPlanDao fpDao = (FlightPlanDao)DAOFactory.getInstance(FlightPlanDao.class);
		boolean boo =fpDao.addFlightPlan(fp);
		System.out.println(fp);
		res.addData("boolean", boo);
	}

}
