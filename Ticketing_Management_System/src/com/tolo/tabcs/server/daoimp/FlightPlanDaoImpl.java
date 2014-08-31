package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tolo.tabcs.common.entity.FlightPlan;
import com.tolo.tabcs.server.dao.FlightPlanDao;
import com.tolo.tabcs.util.ConnectUtils;

public class FlightPlanDaoImpl implements FlightPlanDao{
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private List<FlightPlan> flightPlan= new ArrayList<FlightPlan>();
	
	
	@Override
	public List<FlightPlan> getFlightPlanMessage(String fromPlace, String toPlace) {
		String sql ="select * from flight_plan_cl where route_id in (select route_id from route_cl where "+
		" from_airport_id =(select airport_id from airport_cl "+
		" where airport_full_name = '"+fromPlace+"') and " +
		" to_airport_id = (select airport_id from airport_cl"+
		" where airport_full_name = '"+toPlace+"'))";
	FlightPlan f = null;
	conn = ConnectUtils.getConnection();
	try {
		stmt = conn.createStatement();
		 rs= stmt.executeQuery(sql);
	
	while(rs.next()){
		f = new FlightPlan();
		f.setFp_id(rs.getInt("fp_id"));
		f.setFlight_num(rs.getString("flight_num"));//flight_num
		f.setFp_start_date(rs.getDate("fp_start_date"));//fp_start_date
		f.setFp_end_date(rs.getDate("fp_end_date"));//fp_end_date
		f.setRoute_id(rs.getInt("route_id"));//route_id
		Date d1 = rs.getDate("fp_departure_Date");
		Date d2 = rs.getDate("fp_arrival_Date");
		SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");
		String ds1 = fmt.format(d1);
		String ds2 = fmt.format(d2);
		f.setFp_departure_Date(ds1);//fp_departure_Date
		f.setFp_arrival_Date(ds2);//fp_arrival_Date
		f.setFp_scheduler(rs.getInt("fp_scheduler"));//fp_scheduler
		f.setFp_base_price(rs.getInt("fp_base_price"));//fp_base_price
		f.setFp_season_discount(rs.getDouble("fp_season_discount"));//fp_season_discount
		flightPlan.add(f);
	}
	
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		ConnectUtils.close(rs);
		ConnectUtils.close(stmt);
		ConnectUtils.close(conn);
	}
	return flightPlan;
	}

	@Override
	public List<FlightPlan> getFlightPlanMessageByid(String flightNum) {
		String sql = "select * from flight_plan_cl where flight_num = '"+flightNum.trim()+"'";
		conn = ConnectUtils.getConnection();
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				FlightPlan f = new FlightPlan();
				f.setFp_id(rs.getInt("fp_id"));
				f.setFlight_num(rs.getString("flight_num"));//flight_num
				f.setFp_start_date(rs.getDate("fp_start_date"));//fp_start_date
				f.setFp_end_date(rs.getDate("fp_end_date"));//fp_end_date
				f.setRoute_id(rs.getInt("route_id"));//route_id
				Date d1 = rs.getDate("fp_departure_Date");
				Date d2 = rs.getDate("fp_arrival_Date");
				SimpleDateFormat fmt = new SimpleDateFormat("hh:mm:ss");
				String ds1 = fmt.format(d1);
				String ds2 = fmt.format(d2);
				f.setFp_departure_Date(ds1);//fp_departure_Date
				f.setFp_arrival_Date(ds2);//fp_arrival_Date
				f.setFp_scheduler(rs.getInt("fp_scheduler"));//fp_scheduler
				f.setFp_base_price(rs.getInt("fp_base_price"));//fp_base_price
				f.setFp_season_discount(rs.getDouble("fp_season_discount"));//fp_season_discount
//				f.setFlight_id(rs.getInt("flight_id"));
//				f.setFlight_num(rs.getString("flight_num"));
//				f.setFlight_departu_date(rs.getDate("flight_departu_date"));
//				f.setFlight_arrival_date(rs.getDate("flight_arrival_date"));
//				f.setRoute_id(rs.getInt("route_id"));
//				f.setPlane_id(rs.getInt("plane_id"));
//				f.setF_seats_remain(rs.getInt("f_seats_remain"));
//				f.setB_seats_remain(rs.getInt("b_seats_remain"));
//				f.setE_seats_remian(rs.getInt("e_seats_remian"));
//				f.setLowest_discount_price(rs.getInt("lowest_discount_price"));
				flightPlan.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
//		System.out.println("========="+flightPlan.size());
		return flightPlan;
	}

	public int getBasePrice(int routeid){
		String sql = "select route_base_price from route_cl where route_id ="+routeid;
		conn = ConnectUtils.getConnection();
		int price = 0;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()){
				price = rs.getInt("route_base_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return price;
	}
	@Override
	public boolean updateFlightPlan(FlightPlan f) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sql1 = "update flight_plan_cl set Fp_start_date= to_date('"+fmt.format(f.getFp_start_date())+"','yyyy-mm-dd'), "+
		" Fp_end_date=to_date('"+fmt.format(f.getFp_end_date())+"','yyyy-mm-dd'), Route_id="+f.getRoute_id()+", Fp_departure_Date=to_date('"+f.getFp_departure_Date()+"','hh24:mi:ss'),"
		 +"Fp_arrival_Date=to_date('"+f.getFp_arrival_Date()+"','hh24:mi:ss'), fp_scheduler="+f.getFp_scheduler()+", fp_season_discount="+f.getFp_season_discount()+"," +
		 "fp_base_price ="+getBasePrice(f.getRoute_id())+ " where flight_num='"+f.getFlight_num()+"'";
		
		String sql2 = "insert into mylog_cl values(log_cl.nextval, user, sysdate , 'update flight_plan_cl:修改航班计划表"+f.getFlight_num()+"')";
		conn = ConnectUtils.getConnection();
		boolean b = false;
//		System.out.println(sql1);
		try{
			  conn.setAutoCommit(false);
			  stmt = conn.createStatement();
			  int n1 = stmt.executeUpdate(sql1);
//			  System.out.println("n1:"+n1);
//			  System.out.println(sql2);
			int n2 = stmt.executeUpdate(sql2);
//			System.out.println("n2:"+n2);
			 if(n1==1 && n2 == 1){
			  conn.commit();
			  b = true;
			  }else{
			  conn.rollback();
			   } 
			 conn.setAutoCommit(true);
			}catch(Exception e){
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
		return b;
	}

	@Override
	public boolean deleteFlightPlan(String flightNum) {
		String sql1 =" delete from flight_plan_cl where flight_num = '"+flightNum+"'";
		String sql2 = "insert into mylog_cl values(log_cl.nextval, user, sysdate , 'delete flight_plan_cl:删除航班计划表"+flightNum+"')";
		conn = ConnectUtils.getConnection();
		boolean boo = false;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
			  System.out.println("n1:"+n1);
			int n2 = stmt.executeUpdate(sql2);
			System.out.println("n2:"+n2);
			 if(n1==1 && n2 == 1){
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

	@Override
	public boolean updateSeasonDiscount(String dis,String flightnum) {
		String sql1 = " update flight_plan_cl set fp_season_discount="+Double.parseDouble(dis)+" where flight_num ='"+flightnum+"'";
		String sql2 = "insert into mylog_cl values(log_cl.nextval,user,sysdate" +
				",'update flight_plan_cl:修改某个航班计划表的经济舱季节折扣"+flightnum+"')";
		conn = ConnectUtils.getConnection();
		boolean boo = false;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
			  System.out.println("n1:"+n1);
			int n2 = stmt.executeUpdate(sql2);
			System.out.println("n2:"+n2);
			 if(n1==1 && n2 == 1){
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
			e.printStackTrace();
		}finally{
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return boo;
	}

	@Override
	public boolean updateBatchDiscount(String dis) {
		String sql1 = " update flight_plan_cl set fp_season_discount="+Double.parseDouble(dis);
		String sql2 = "insert into mylog_cl values(log_cl.nextval,user,sysdate" +
				",'update flight_plan_cl:修改所有航班计划表的经济舱季节折扣')";
		conn = ConnectUtils.getConnection();
		boolean boo = false;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
			  System.out.println("n1:"+n1);
			int n2 = stmt.executeUpdate(sql2);
			System.out.println("n2:"+n2);
			 if(n1==2 && n2 == 1){
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
			e.printStackTrace();
		}finally{
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return boo;
	}
	public int findRoutePrice(int routeid){
		String sql = "select route_base_price from route_cl where route_id = "+routeid;
		conn = ConnectUtils.getConnection();
		ResultSet rs3 = null; 
		int price = 0;
		try {
			stmt = conn.createStatement();
			rs3 = stmt.executeQuery(sql);
			if(rs3.next()){
				price = rs3.getInt("route_base_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs3);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return price;
	}
	@Override
	public boolean addFlightPlan(FlightPlan f) {
		boolean boo = false;
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss");
		String sql1 = "insert into flight_plan_cl values(plan.nextval,'"+f.getFlight_num()+"',to_date('"+fmt.format(f.getFp_start_date())+"','yyyy-mm-dd')," +
				" to_date('"+fmt.format(f.getFp_end_date())+"','yyyy-mm-dd'), "+f.getRoute_id()+", to_date('"+f.getFp_departure_Date()+"','hh24:mi:ss'), to_date('"+f.getFp_arrival_Date()+"','hh24:mi:ss'),"+
						f.getFp_scheduler()+", "+findRoutePrice(f.getRoute_id())+","+f.getFp_season_discount()+")";
		String sql2 = "insert into mylog_cl values(log_cl.nextval, " +
			"user, sysdate , 'delete flight_cl:添加航班计划表"+f.getFlight_num()+"')";
		try {
			conn = ConnectUtils.getConnection();
			 System.out.println(sql1);
			  System.out.println(sql2);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
			  System.out.println("n1:"+n1);
			int n2 = stmt.executeUpdate(sql2);
			System.out.println("n2:"+n2);
			 if(n1==1 && n2 == 1){
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
