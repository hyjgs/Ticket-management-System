package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RemoveAirline;
import com.tolo.tabcs.server.daoimp.RemoveAirlineImp;
import com.tolo.tabcs.server.service.ServerAction;

public class RemoveAirlineAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
	   int n =(Integer)req.getData("routeId");
	   RemoveAirline remove = new RemoveAirlineImp();
	   String str = (String)remove.removeAirline(n);
		res.addData("result", str);
	}

}
