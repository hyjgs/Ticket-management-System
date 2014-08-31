package com.tolo.tabcs.server.dao;

public interface ChangeTicketDao {
	int getBranchId(String[] str);
	boolean insertBusRec(String[] str);
}
