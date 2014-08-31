package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.PlaneDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchconfuelAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String ftype = (String)req.getData("flightype");
		PlaneDao pDao = (PlaneDao)DAOFactory.getInstance(PlaneDao.class);
		int conf = pDao.findConfuel(ftype);
		res.addData("con", conf);
	}

}
