package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.ChangeTicketDao;
import com.tolo.tabcs.server.daoimp.ChangeTicketDaoImp;
import com.tolo.tabcs.server.service.ServerAction;

public class ChangeTicketAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
          String[] str = (String[])req.getData("change");
        ChangeTicketDao dao = new ChangeTicketDaoImp();        
        boolean bool = dao.insertBusRec(str);
        res.addData("boolean", bool);
	}

}
