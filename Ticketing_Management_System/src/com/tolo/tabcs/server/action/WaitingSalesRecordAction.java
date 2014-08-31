package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.daoimp.SalesRecordDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 等待营业结算
 * @author hyj
 *
 */
public class WaitingSalesRecordAction extends ServerAction{
	 public void doAction(Request req, Response res){
//		 System.out.println("got to the waitings_action");
		 int user_id = (Integer)req.getData("user_id");
		 SalesRecordDao record = new SalesRecordDaoImp();
			SalesRecord[] records = record.showWaiting(user_id);
		 res.addData("result", records);
			 }
}
