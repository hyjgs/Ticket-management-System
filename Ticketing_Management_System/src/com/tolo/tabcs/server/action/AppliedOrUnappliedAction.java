package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.AppliedRecord;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;
/**
 * 得到营业记录
 * @author hyj
 *
 */
public class AppliedOrUnappliedAction extends ServerAction {
	public void doAction(Request req, Response res) {
		User user = (User) req.getData("user");
		int branch_id = user.getBranch_id();
		SalesRecordDao record = (SalesRecordDao) DAOFactory
				.getInstance(SalesRecordDao.class);
		AppliedRecord[] result = record.getApplied(branch_id);
		res.addData("result", result);
	}

}
