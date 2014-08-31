package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.UpdateMilage;
import com.tolo.tabcs.server.daoimp.UpdateMilageImp;
import com.tolo.tabcs.server.service.ServerAction;

public class UpdateMileageAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
	   Route route =(Route)req.getData("mileage");
	   
	   System.out.println(route.getRoute_id());
	   System.out.println(route.getRoute_distance());
		UpdateMilage update = new UpdateMilageImp();
		String str  = update.UpdateMilage(route);
		res.addData("result", str);
	}

}
