package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchDao;
import com.tolo.tabcs.server.daoimp.BranchDaoImp;
import com.tolo.tabcs.server.service.ServerAction;

/**
 * 删除营业网点
 * @author hyj
 *
 */
public class RemoveBranchAction extends ServerAction {
	public void doAction(Request req, Response res) {
		int branch_id = Integer.parseInt((String) req.getData("删除网点"));
		System.out.println("branch_id is " + branch_id);
		BranchDao branchdao = new BranchDaoImp();
		boolean r = branchdao.removeBranch(branch_id);
		res.addData("删除网点状态", r);
	}
}
