package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RouteDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchAirlineByNoneAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		RouteDao routeDao = (RouteDao)DAOFactory.getInstance(RouteDao.class);
		Integer[] routes = routeDao.searchAllRouteId();
		res.addData("airLine", routes);
	}

}
