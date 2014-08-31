package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerRemoveUserAction extends ServerAction{

	public void doAction(Request req, Response res) {
		//User user = (User) req.getData("userid");
		User user =(User)req.getData("userid");
		System.out.println("=========doAction"+user.getId());
		UserDao userdao = (UserDao)DAOFactory.getInstance(UserDao.class);
		boolean flag = userdao.removeUser(user);
		res.addData("删除状态", flag);
	}
	
}
