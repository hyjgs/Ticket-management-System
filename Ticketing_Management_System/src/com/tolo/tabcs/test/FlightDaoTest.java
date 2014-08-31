package com.tolo.tabcs.test;

import java.util.Date;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.server.daoimp.FlightDaoImpl;

public class FlightDaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FlightDao dao = new FlightDaoImpl();
		Flight flight = new Flight();
		flight.setFlight_num("TL1202");
		flight.setLowest_discount_price(487);
		flight.setFlight_departu_date(new Date());
		flight.setFlight_arrival_date(new Date());
		flight.setPlane_id(1001203159);
		flight.setRoute_id(100002);
//		dao.updateFlight(flight);
		boolean b = dao.addFlight(flight);
		System.out.println(b);
	}

}
