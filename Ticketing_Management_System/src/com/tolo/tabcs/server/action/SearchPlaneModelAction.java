package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.PlaneDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchPlaneModelAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		PlaneDao planedao = (PlaneDao) DAOFactory.getInstance(PlaneDao.class);
		int planeId = (Integer)req.getData("plane_id");
		String planemodel = planedao.searchPlaneModel(planeId);
//		System.out.println(planemodel+"  //sss");
		res.addData("pmodel", planemodel);
	}
	
}
