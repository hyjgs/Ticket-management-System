package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.TicketDao;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class OrderTicketAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		List<Ticket> tickets = (List<Ticket>)req.getData("tickets");
		System.out.println(tickets);
		TicketDao tDao = (TicketDao)DAOFactory.getInstance(TicketDao.class);
		boolean boo = tDao.insertTicket(tickets, null, null);
	}
	
}
