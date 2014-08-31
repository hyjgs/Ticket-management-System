package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class UpdateFlightAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		FlightDao fdao = (FlightDao)DAOFactory.getInstance(FlightDao.class);
		Flight f = (Flight)req.getData("flight");
		boolean b = fdao.updateFlight(f);
		res.addData("boolean", b);
	}

}
