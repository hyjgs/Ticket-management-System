package com.tolo.tabcs.server.action;

import java.util.LinkedList;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.SearchLine;
import com.tolo.tabcs.server.daoimp.SearchLineImp;
import com.tolo.tabcs.server.service.ServerAction;

public class SearchLineAction  extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
		System.out.println("=======doAction");
	 // cityToCity ctc = (cityToCity)req.getData("ctc");
		
	/*	Route route = (Route)req.getData("route0");	
	    SearchLine searchLine = new SearchLineImp();*/
	  
	  //LinkedList<Route> list =(LinkedList<Route>)searchLine.getFromName(ctc);
	 // LinkedList<Route> list =(LinkedList<Route>)searchLine.getFromName(route);
	/*  int[] a = (int[])searchLine.getRouteId(route);
	  res.addData("result",a);
*/
	  
	/*  Route route1=(Route)req.getData("route1");
	  SearchLine searchLine1 = new SearchLineImp();
	  LinkedList<Route> list =(LinkedList<Route>)searchLine1.getAllRoute(route1);
	  res.addData("result1",list);
	  */
	  SearchLine searchLine = new SearchLineImp();
	  if(req.getData("route1")==null){
			Route route = (Route)req.getData("route0");	
		 int[] a = (int[])searchLine.getRouteId(route);
		 res.addData("result",a);
		 
	  }else{
		  Route route1=(Route)req.getData("route1");
		  LinkedList<Route> list =(LinkedList<Route>)searchLine.getAllRoute(route1);
		   res.addData("result1",list);
		    Route r=list.getFirst();
		    System.out.println(r.getRoute_id());
			System.out.println(r.getFrom_airport_name());
			System.out.println(r.getTo_airport_name());
			System.out.println(r.getRoute_distance());
	  }
	  
   }
}