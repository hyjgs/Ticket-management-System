package com.tolo.tabcs.server.action;
import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.BranchDao;
import com.tolo.tabcs.server.daoimp.BranchDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 更新营业网点
 * @author hyj
 *
 */
public class UpdateBranchAction extends ServerAction{
	public void doAction(Request req, Response res){
		Branch branch = (Branch)req.getData("修改网点");
		BranchDao branchdao = new BranchDaoImp();
		boolean flag = branchdao.updateBranch(branch);
		res.addData("修改网点状态", flag);
	}
}
