package com.tolo.tabcs.server.action;

import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.IdTicketInfo;
import com.tolo.tabcs.server.dao.NumTicketInfo;
import com.tolo.tabcs.server.daoimp.IdTicketInfoImp;
import com.tolo.tabcs.server.daoimp.NumTicketInfoImp;
import com.tolo.tabcs.server.service.ServerAction;

public class CertifNumTicketInfoAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
	  String str = (String)req.getData("num");
	
		System.out.println(str);
		NumTicketInfo  ticketInfo  =new NumTicketInfoImp(); 		
		ArrayList<Ticket> arr =(ArrayList<Ticket>)ticketInfo.getTicketInfo2(str);
		
		System.out.println("====doAction"+arr);
		if(arr==null){
			res.addData("result1", "isNull");
			System.out.println("不存在该数据");
		}else{
           res.addData("result1", arr);
		}
	}

}
