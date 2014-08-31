package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.daoimp.SalesRecordDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 查找未结算的营业记录
 * @author hyj
 *
 */
public class SearchUncheckedSalesRecordAction extends ServerAction{
	public void doAction(Request req, Response res){
		int user_id = (Integer)req.getData("user_id");
		SalesRecordDao salesRecordDao = new SalesRecordDaoImp();
		SalesRecord[] records = salesRecordDao.getUncheckedRecord(user_id);
		res.addData("result",records);
	}
}