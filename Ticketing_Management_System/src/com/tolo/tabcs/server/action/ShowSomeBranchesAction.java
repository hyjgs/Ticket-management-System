package com.tolo.tabcs.server.action;
import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchDao;
import com.tolo.tabcs.server.daoimp.BranchDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 按各种条件查找营业网点
 * @author hyj
 *
 */
public class ShowSomeBranchesAction extends ServerAction{
	public void doAction(Request req, Response res){
		Branch branch = (Branch)req.getData("branch");
		BranchDao branchdao = new BranchDaoImp();
		Branch[] branches = branchdao.getSomeBranches(branch);
//		System.out.println(branches[0].getBranch_address());
		if(branches!=null){
		res.addData("result",branches);
		}else{
			res.addData("result", null);
		}
	}
}
