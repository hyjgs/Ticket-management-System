package com.tolo.tabcs.server.action;

import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.IdTicketInfo;
import com.tolo.tabcs.server.daoimp.IdTicketInfoImp;
import com.tolo.tabcs.server.service.ServerAction;

public class IdTicketInfoAction  extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		int n= (Integer)req.getData("ticketID");
		System.out.println(n);
		IdTicketInfo ticketInfo =new IdTicketInfoImp(); 
		ArrayList<Ticket> arr =(ArrayList<Ticket>)ticketInfo.getTicketInfo(n);
		
		System.out.println("====doAction"+arr);
		if(arr==null){
			res.addData("result", "isNull");
		}else{
           res.addData("result", arr);
		}
	}

}
