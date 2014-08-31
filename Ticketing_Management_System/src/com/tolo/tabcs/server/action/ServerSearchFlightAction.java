package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.dao.UserDao;
import com.tolo.tabcs.server.daoimp.FlightDaoImpl;
import com.tolo.tabcs.server.service.ServerAction;
import com.tolo.tabcs.util.DAOFactory;

public class ServerSearchFlightAction extends ServerAction{

	/**
	 * @param req 从客户端传递过来的request同一个请求
	 * @param res 控制器创建并且将要返回到客户端的应答
	 *  
	 */ 
	@Override
	public void doAction(Request req, Response res) {
		String str1 = (String) req.getData("from_place");
		String str2 = (String) req.getData("to_place");
//		System.out.println(str1);
//		System.out.println(str2);
		String[] tp = str1.split("-");
		String[] tp1 = str2.split("-");
//		System.out.println(tp[0]);
//		System.out.println(tp1[0]);
//		System.out.println(tp.length);
//		System.out.println(tp1.length);
		String from_place = tp[1];
		String to_place = tp1[1];
//		System.out.println(from_place);
//		System.out.println(to_place);
		FlightDao flightDao = (FlightDao)DAOFactory.getInstance(FlightDao.class);
		List<Flight> flight = flightDao.getFlightMessage(from_place,to_place);
//		System.out.println(flight);
//		System.out.println(flight.size());
		res.addData("flightMessage", flight);
	}

}
