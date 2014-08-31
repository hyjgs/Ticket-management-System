package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RoleDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerUpdateRoleAction extends ServerAction{

	public void doAction(Request req, Response res) {
			Role role = (Role) req.getData("updaterole"); 
			//	System.out.println(role.getName());
			RoleDao roledao = (RoleDao)DAOFactory.getInstance(RoleDao.class);
			boolean flag = roledao.updateRole(role);
			res.addData("修改状态", flag);
	}
	
}
