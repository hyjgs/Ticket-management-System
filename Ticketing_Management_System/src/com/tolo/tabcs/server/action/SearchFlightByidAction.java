package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchFlightByidAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		FlightDao flightDao = (FlightDao)DAOFactory.getInstance(FlightDao.class);
		String flightNum = (String)req.getData("flight_num");
		List<Flight> flight = flightDao.getFlightMessageByid(flightNum);
		res.addData("flight", flight);
//		System.out.println(flight);
	}

}
