package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.ProvinceDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchProvinceAction extends ServerAction{
	public void doAction(Request req, Response res) {
		ProvinceDao provinceDao = (ProvinceDao)DAOFactory.getInstance(ProvinceDao.class);
		List list = provinceDao.getProvince();
		res.addData("查询省份", list);
	}

}
