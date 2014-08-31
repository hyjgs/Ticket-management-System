package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.PlaneDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchPlaneIDByModelAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		PlaneDao planeDao = (PlaneDao)DAOFactory.getInstance(PlaneDao.class);
		String type = (String)req.getData("type");
		int planeId = planeDao.searchPlaneId(type);
		res.addData("planeId", planeId);
	}

}
