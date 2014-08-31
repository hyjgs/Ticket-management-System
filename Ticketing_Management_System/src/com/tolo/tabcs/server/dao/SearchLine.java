package com.tolo.tabcs.server.dao;

import java.util.LinkedList;

import com.tolo.tabcs.common.entity.Route;


public interface SearchLine {
 /*   LinkedList<Route>  getRes(cityToCity ctc);
   // public LinkedList<Route> ctcData(cityToCity ctc);
    int[] getIdDistance(cityToCity ctc);
    String[] getAirportFromName(cityToCity ctc);
    String[] getAirportToName(cityToCity ctc);*/
	
/*	LinkedList<Route> getFromName(Route route);
	int[] getIdDistance(Route route);*/
    int[] getRouteId(Route route);
	LinkedList<Route> getAllRoute(Route route);
	
}
