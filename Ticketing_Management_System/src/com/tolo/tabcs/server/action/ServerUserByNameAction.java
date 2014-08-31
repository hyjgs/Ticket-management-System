package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerUserByNameAction extends ServerAction{
	public void doAction(Request req, Response res) {
		User userName = (User) req.getData("userByName");
		System.out.println("name = "+userName.getName());
		UserDao userdao = (UserDao)DAOFactory.getInstance(UserDao.class);
		List<User> list1 = userdao.getUserByName(userName);
		res.addData("userByName", list1);
	}
}
