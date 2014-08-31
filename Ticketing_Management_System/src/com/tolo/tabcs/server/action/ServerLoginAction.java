package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.*;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.server.daoimp.UserDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;
/**
 * 登录
 * @author hyj
 *
 */
public class ServerLoginAction extends ServerAction{
 public void doAction(Request req, Response res){
	 User user = (User)req.getData("user");
	// UserDao userDao = (UserDao)DAOFactory.getInstance(UserDao.class);
	//	UserDao userDao = (UserDao)DAOFactory.getInstance(UserDao.class);
	 UserDao userDao = new UserDaoImp();
	 	User user1 = userDao.getUser2(user);
	 	res.addData("result",user1);
 }
	
}
