package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchFlightPlanAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String str1 = (String)req.getData("from_place");
		String str2 = (String)req.getData("to_place");
		String[] tp = str1.split("-");
		String[] tp1 = str2.split("-");
		String from_place = tp[1];
		String to_place = tp1[1];
		FlightPlanDao fpDao = (FlightPlanDao)DAOFactory.getInstance(FlightPlanDao.class);
		List<FlightPlan> list = fpDao.getFlightPlanMessage(from_place, to_place);
		System.out.println(list+":length "+list.size());
		res.addData("flightPlanMessage", list);
	}

}
