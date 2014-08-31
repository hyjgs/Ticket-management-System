package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class Batch_UpdateDiscountAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String dis = (String)req.getData("disc");
//		String flightnum = (String)req.getData("flight_num");
		FlightPlanDao fpDao = (FlightPlanDao)DAOFactory.getInstance(FlightPlanDao.class);
		boolean bool = fpDao.updateBatchDiscount(dis);
		res.addData("boolean", bool);
	}

}