package com.tolo.tabcs.server.action;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.AddLine;
import com.tolo.tabcs.server.daoimp.AddLineImp;
import com.tolo.tabcs.server.service.ServerAction;

public class AddLineAction extends ServerAction {
   public void doAction(Request req,Response res){
	   Route route = (Route)req.getData("addRoute");
	   AddLine addLine = new AddLineImp();
	   String str = (String)addLine.insertLine(route);
	   if(str=="ok"){
		   res.addData("okAdd", str);
	   }
   }
	
}
/*	public void doAction(Request req, Response res) {
		System.out.println("=======doAction");
	 // cityToCity ctc = (cityToCity)req.getData("ctc");
		Route route = (Route)req.getData("route0");
		
	    SearchLine searchLine = new SearchLineImp();
	  
	  //LinkedList<Route> list =(LinkedList<Route>)searchLine.getFromName(ctc);
	  LinkedList<Route> list =(LinkedList<Route>)searchLine.getFromName(route);
	  
	  res.addData("result", list);
}*/
