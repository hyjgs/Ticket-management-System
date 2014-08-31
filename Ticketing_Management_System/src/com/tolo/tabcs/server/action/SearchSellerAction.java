package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.SalesRecord;
import com.tolo.tabcs.common.entity.Seller;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SalesRecordDao;
import com.tolo.tabcs.server.dao.SellerDao;
import com.tolo.tabcs.server.daoimp.SalesRecordDaoImp;
import com.tolo.tabcs.server.daoimp.SellerDaoImp;
import com.tolo.tabcs.server.service.ServerAction;
/**
 * 查找营业员
 * @author hyj
 *
 */
public class SearchSellerAction extends ServerAction{
	public void doAction(Request req, Response res){
		int user_id = (Integer)req.getData("seller");
		SellerDao sellerDao = new SellerDaoImp();
		Seller record = sellerDao.getSeller(user_id);
		res.addData("result",record);
	}

}
