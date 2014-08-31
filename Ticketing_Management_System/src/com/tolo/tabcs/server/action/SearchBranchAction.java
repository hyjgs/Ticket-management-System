package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchNameDao;
import com.tolo.tabcs.server.daoimp.BranchNameDaoImpl;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 查找营业网点
 * @author hyj
 *
 */
public class SearchBranchAction extends ServerAction{
	public void doAction(Request req, Response res) {
		String cityName = (String)req.getData("城市下的网点");
		BranchNameDao branchNameDao = new BranchNameDaoImpl();
		List list = branchNameDao.getBranchName(cityName);
		res.addData("城市下的网点", list);
	}

}
