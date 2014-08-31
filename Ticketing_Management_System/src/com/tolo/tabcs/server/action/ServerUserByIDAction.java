package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerUserByIDAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		User userID = (User) req.getData("userByID");
		UserDao userdao = (UserDao)DAOFactory.getInstance(UserDao.class);
		List<User> list1 = userdao.getUserByID(userID);
		res.addData("userByID", list1);
	}
	
}
