package com.tolo.tabcs.server.action;

import java.util.Arrays;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RouteDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchFTPlaceByRouteId extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		int rid = (Integer)req.getData("routeId");
		RouteDao routeDao = (RouteDao)DAOFactory.getInstance(RouteDao.class);
		String[] str = routeDao.findPlaceByRouteId(rid);
		res.addData("from", str[0]);
		res.addData("to", str[1]);
	}

}
