package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RoleDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerDelRoleAction extends ServerAction{
	public void doAction(Request req, Response res) {
		Role role = (Role) req.getData("删除角色"); 
	//	System.out.println(role.getName());
		RoleDao roledao = (RoleDao)DAOFactory.getInstance(RoleDao.class);
		boolean flag = roledao.delRole(role);
		res.addData("删除角色状态", flag);
	}

}
