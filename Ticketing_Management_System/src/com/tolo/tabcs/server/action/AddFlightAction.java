package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class AddFlightAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		Flight f =(Flight)req.getData("flight");
		FlightDao fDao = (FlightDao)DAOFactory.getInstance(FlightDao.class);
//		System.out.println(f);
		boolean boo = fDao.addFlight(f);
		res.addData("boolean", boo);
	}

}
