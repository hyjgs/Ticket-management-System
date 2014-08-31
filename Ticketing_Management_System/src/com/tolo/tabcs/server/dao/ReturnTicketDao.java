package com.tolo.tabcs.server.dao;

public interface ReturnTicketDao {
	
	int getBranchId(String[] str);
	
	boolean insertBusRec(String[] str);
}
