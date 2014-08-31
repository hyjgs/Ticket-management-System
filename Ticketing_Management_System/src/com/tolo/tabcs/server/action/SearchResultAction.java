package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SearchResultDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchResultAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String[] message = (String[])req.getData("message");
		SearchResultDao searchResult = (SearchResultDao) DAOFactory.getInstance(SearchResultDao.class);
		List result = searchResult.getResult(message);
		System.out.println(result);
		res.addData("result", result);
	}

}
