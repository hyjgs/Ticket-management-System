package com.tolo.tabcs.server.action;

import java.util.Arrays;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.PlaneDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchairPlaneModelByNoneAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		PlaneDao planeDao =(PlaneDao)DAOFactory.getInstance(PlaneDao.class);
		String[] str = planeDao.searchPlaneModelByNone();
//		System.out.println(Arrays.toString(str));
		res.addData("airplanemodel", str);
	}

}
