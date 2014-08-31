package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.ReturnTicketDao;
import com.tolo.tabcs.server.daoimp.ReturnTicketDaoImp;
import com.tolo.tabcs.server.service.ServerAction;

public class ReturnTicketAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		String[] s = (String[])req.getData("IdCertifNum");
		
		ReturnTicketDao dao = new ReturnTicketDaoImp();
	    boolean bool = dao.insertBusRec(s);
	    res.addData("boolean",bool);
	}

}
