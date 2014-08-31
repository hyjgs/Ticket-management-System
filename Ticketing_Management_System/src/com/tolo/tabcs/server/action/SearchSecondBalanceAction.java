package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SecondBalanceDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;
/**
 * 查找二级结算
 * @author hyj
 *
 */
public class SearchSecondBalanceAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		int branchId = (Integer)req.getData("branch_Id");
		SecondBalanceDao secondBalance = (SecondBalanceDao) DAOFactory.getInstance(SecondBalanceDao.class);
		Boolean result = secondBalance.getResult(branchId);
		res.addData("result", result);
	}

}
