package com.tolo.tabcs.server.action;

import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ConfirmFirstAction extends ServerAction{
	 public void doAction(Request req, Response res){
		List list = (ArrayList)req.getData("list");
		int seller_id = (Integer) list.get(0);
		   SalesRecordDao record = (SalesRecordDao)DAOFactory.getInstance(SalesRecordDao.class);
		 boolean result = record.toFirstCheck(seller_id);
		 res.addData("result", result);
	 }
}
