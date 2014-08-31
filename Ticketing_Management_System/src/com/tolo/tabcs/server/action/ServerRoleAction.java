package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.RoleDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerRoleAction extends ServerAction{
public void doAction(Request req, Response res) {
	RoleDao roledao = (RoleDao)DAOFactory.getInstance(RoleDao.class);
	List<Role> list = roledao.searchAllRole();
	res.addData("all", list);
}
}
