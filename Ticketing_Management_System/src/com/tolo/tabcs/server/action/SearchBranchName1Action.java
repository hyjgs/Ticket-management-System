package com.tolo.tabcs.server.action;

import java.util.Arrays;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchName1Dao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class SearchBranchName1Action extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
//		System.out.println("to search action");
		BranchName1Dao branchNameDao = (BranchName1Dao) DAOFactory.getInstance(BranchName1Dao.class);
		String[] branchName = branchNameDao.getBranchName();
//		System.out.println("the doaction re "+Arrays.toString(branchName));
		res.addData("branchName", branchName);
	}

}
