package com.tolo.tabcs.server.dao;

import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Ticket;

public interface IdTicketInfo {
	ArrayList<Ticket> getTicketInfo(int n);
}
