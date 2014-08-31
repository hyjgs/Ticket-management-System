package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RouteDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchOilfuelAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		int flightairline = (Integer)req.getData("flightairline");
		RouteDao rDao = (RouteDao)DAOFactory.getInstance(RouteDao.class);
		int oil =rDao.findOilFuel(flightairline);
		res.addData("tax", oil);
	}
	
}
