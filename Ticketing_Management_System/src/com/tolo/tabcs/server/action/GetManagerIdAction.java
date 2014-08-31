package com.tolo.tabcs.server.action;

import java.util.ArrayList;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.*;
import com.tolo.tabcs.server.daoimp.*;
import com.tolo.tabcs.server.service.ServerAction;
public class GetManagerIdAction extends ServerAction{
	 public void doAction(Request req, Response res){
		 ManagerDao managerDao = new ManagerDaoImp();
		 ArrayList<Integer> list = managerDao.managerAll();
		 System.out.println("the size is "+ list.size());
		 res.addData("查询经理ID", list);
	 }
}
