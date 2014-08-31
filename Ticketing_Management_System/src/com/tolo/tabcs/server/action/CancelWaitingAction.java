package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.daoimp.SalesRecordDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 取消结算的申请
 * @author hyj
 *
 */
public class CancelWaitingAction extends ServerAction{
	 public void doAction(Request req, Response res){
		 int buss_red_id = (Integer)req.getData("buss_red_id");
		 int user_id = (Integer)req.getData("user_id");
		 SalesRecordDao record = new SalesRecordDaoImp();
		 boolean flag = record.cancelWaiting(buss_red_id,user_id);
		 res.addData("result", flag);
		 
	 }

}
