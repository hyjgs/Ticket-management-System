package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class RemoveFlightAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		FlightDao fDao  = (FlightDao)DAOFactory.getInstance(FlightDao.class);
		String str = (String)req.getData("flight_num");
		boolean boo = fDao.deleteFlight(str);
		res.addData("boolean", boo);
	}
	
	
	
}
