package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.UserNameDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchUserNameAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String branchName = (String) req.getData("branchName");
		UserNameDao userNameDao = (UserNameDao) DAOFactory.getInstance(UserNameDao.class);
		List list = userNameDao.getUserName(branchName);
		res.addData("userName", list);
	}

}
