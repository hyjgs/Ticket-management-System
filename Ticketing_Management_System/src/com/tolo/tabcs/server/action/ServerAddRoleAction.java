package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RoleDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerAddRoleAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		Role newrole = (Role) req.getData("newrole"); 
		RoleDao roledao = (RoleDao)DAOFactory.getInstance(RoleDao.class);
		boolean flag = roledao.addRole(newrole);
		res.addData("添加状态", flag);
	}

}
