package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import com.tolo.tabcs.common.entity.OrderItem;
import com.tolo.tabcs.common.entity.Passenger;
import com.tolo.tabcs.common.entity.Ticket;
import com.tolo.tabcs.server.dao.TicketDao;
import com.tolo.tabcs.util.ConnectUtils;

public class TicketDaoImpl implements TicketDao{
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	@Override
	public boolean insertTicket(List<Ticket> t, List<OrderItem> o,
			List<Passenger> p) {
		boolean boo = false;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sql1 ="";
//		"insert into flight_plan_cl values(plan.nextval,'"+f.getFlight_num()+"',to_date('"+fmt.format(f.getFp_start_date())+"','yyyy-mm-dd')," +
//				" to_date('"+fmt.format(f.getFp_end_date())+"','yyyy-mm-dd'), "+f.getRoute_id()+", to_date('"+f.getFp_departure_Date()+"','hh24:mi:ss'), to_date('"+f.getFp_arrival_Date()+"','hh24:mi:ss'),"+
//						f.getFp_scheduler()+", "+findRoutePrice(f.getRoute_id())+","+f.getFp_season_discount()+")";
//		String sql2 = "insert into mylog_cl values(log_cl.nextval, " +
//			"user, sysdate , 'delete flight_cl:添加航班计划表"+f.getFlight_num()+"')";
		try {
			conn = ConnectUtils.getConnection();
			System.out.println(sql1);
//			System.out.println(sql2);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
			System.out.println("n1:"+n1);
//			int n2 = stmt.executeUpdate(sql2);
			System.out.println("n2:");
			 if(n1==1 ){
				  conn.commit();
				  boo = true;
				  }else{
				  conn.rollback();
				   } 
				 conn.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				}
			e.printStackTrace();
		}finally{
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return boo;
	}

}
