package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.CityDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchCityAction extends ServerAction{
	public void doAction(Request req, Response res) {
		String province = (String) req.getData("省份下的城市名称");
		CityDao cityDao = (CityDao)DAOFactory.getInstance(CityDao.class);
		List list = cityDao.getCity(province);
		res.addData("省份下的城市名称", list);
		
	}

}
