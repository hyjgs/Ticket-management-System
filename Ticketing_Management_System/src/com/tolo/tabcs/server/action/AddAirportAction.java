package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Airport;
import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.AddAirport;
import com.tolo.tabcs.server.dao.AddLine;
import com.tolo.tabcs.server.daoimp.AddAirportImp;
import com.tolo.tabcs.server.daoimp.AddLineImp;
import com.tolo.tabcs.server.service.ServerAction;

public class AddAirportAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		Airport airport = (Airport)req.getData("addAirport");
		
		AddAirport addairport = new AddAirportImp();
		String str =addairport.addAirport(airport);
		if(str!=null){
			res.addData("okadd",str);
		}
		
	}

}

