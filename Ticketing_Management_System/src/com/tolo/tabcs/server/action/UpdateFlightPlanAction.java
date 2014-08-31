package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class UpdateFlightPlanAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		FlightPlan fp = (FlightPlan)req.getData("flight");
		FlightPlanDao fdao = (FlightPlanDao)DAOFactory.getInstance(FlightPlanDao.class);
//		System.out.println("传过来的:"+fp);
		boolean boo =fdao.updateFlightPlan(fp);
		res.addData("boolean", boo);
	}

}
