package com.tolo.tabcs.server.action;
import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.daoimp.SalesRecordDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 查找营业记录
 * @author hyj
 *
 */
public class SearchSalesRecordAction extends ServerAction{
	public void doAction(Request req, Response res){
		String from = (String)req.getData("from");
		String to = (String)req.getData("to");
//		int user_id
		SalesRecordDao salesRecordDao = new SalesRecordDaoImp();
		SalesRecord[] records = salesRecordDao.getRecord(from,to);
		res.addData("result",records);
	}
}
