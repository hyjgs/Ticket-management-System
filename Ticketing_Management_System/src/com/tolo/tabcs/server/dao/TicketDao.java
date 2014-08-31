package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.OrderItem;
import com.tolo.tabcs.common.entity.Passenger;
import com.tolo.tabcs.common.entity.Ticket;

public interface TicketDao {

	boolean insertTicket(List<Ticket> t, List<OrderItem> o, List<Passenger> p);

}
