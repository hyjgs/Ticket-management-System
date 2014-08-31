package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchDao;
import com.tolo.tabcs.server.daoimp.BranchDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
//该动作暂时未被调用
public class ShowAllBranchesAction extends ServerAction {
	public void doAction(Request req, Response res){
		BranchDao branchdao = new BranchDaoImp();
		boolean r= branchdao.getAllBranches();
		if(r) {
			res.addData("result","haha");
		}else {
			res.addData("result","no date");
		}
	}
}
