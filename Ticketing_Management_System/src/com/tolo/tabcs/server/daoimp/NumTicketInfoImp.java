package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.server.dao.NumTicketInfo;
import com.tolo.tabcs.util.CollectionUtils;

public class NumTicketInfoImp implements NumTicketInfo{
	 public ArrayList<Ticket> getTicketInfo2(String s){
	    	String sql1 ="select flight_num,sta_from_airport,end_from_airport,psg_name," +
	    		"  to_char(sta_fly_date,'yyyy-mm-dd') sta_fly_date,ticket_price from tickets_cl " +
	    		"where psg_id=(select psg_id from passenger_cl where psg_certif_num='"+s+"')";
	    	
	         System.out.println(sql1);
	      //   System.out.println(sql2);
	         Connection conn = CollectionUtils.getConnection();
	         Statement stmt = null;
	         ResultSet rs1 = null;
	       //  ResultSet rs2= null;
	         Ticket ticket= new Ticket();
	         ArrayList<Ticket>  arr = new ArrayList<Ticket>();
	         try {
				stmt=conn.createStatement();
				rs1 =stmt.executeQuery(sql1);
				while(rs1.next()){
					ticket.setFlight_num(rs1.getInt("flight_num"));
					ticket.setSta_from_airport(rs1.getString("sta_from_airport"));
					ticket.setEnd_from_airport(rs1.getString("end_from_airport"));
					ticket.setPsg_name(rs1.getString("psg_name"));
					ticket.setTicket_start_date(rs1.getString("sta_fly_date"));
					ticket.setTicket_price(rs1.getInt("ticket_price"));
					
					ticket.setPsg_certif_numl(s);
					
				      System.out.println(rs1.getInt("flight_num"));
				      System.out.println(rs1.getString("sta_from_airport"));
				      System.out.println(rs1.getString("end_from_airport"));
				      System.out.println(rs1.getString("psg_name"));
				      System.out.println(rs1.getString("sta_fly_date"));
				      System.out.println(rs1.getInt("ticket_price"));
				        
				}
				/*rs2 =stmt.executeQuery(sql2);
				while(rs2.next()){
				String s2=	rs2.getString("psg_certif_num");
					ticket.setPsg_certif_numl(s2);
				}*/
				arr.add(ticket);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				CollectionUtils.close(rs1);
				//CollectionUtils.close(rs2);
				CollectionUtils.close(stmt);
				CollectionUtils.close(conn);
			}
	         
	    	return arr;
	    }
}
