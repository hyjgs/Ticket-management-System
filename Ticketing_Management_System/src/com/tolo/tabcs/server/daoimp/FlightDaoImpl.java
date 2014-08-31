package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.tolo.tabcs.common.entity.Flight;
import com.tolo.tabcs.server.dao.FlightDao;
import com.tolo.tabcs.util.ConnectUtils;

public class FlightDaoImpl implements FlightDao{
	private Connection conn = null;
	private Statement stmt = null;
	private List<Flight> flight = new ArrayList<Flight>();
	private ResultSet rs = null;
	
	@Override
	public List<Flight> getFlightMessage(String fromPlace, String toPlace) {
//		String sql = "select * from flight_cl where route_id in "+
//		"(select e.route_id from route_cl e join airport_cl a "+
//		" on  e.from_airport_id =a.airport_id "+
//		" where e.from_airport_id  in (select k.airport_id from airport_cl k join city_cl f "+
//		" on k.city_id = f.city_id where city_name = '"+fromPlace+"') " +
//		" and e.to_airport_id in  (select i.airport_id from airport_cl i join city_cl o "+ 
//		" on i.city_id = o.city_id where city_name = '"+toPlace+"'))";
		String sql ="select * from flight_cl where route_id in (select route_id from route_cl where "+
				" from_airport_id =(select airport_id from airport_cl "+
				" where airport_full_name = '"+fromPlace+"') and " +
				" to_airport_id = (select airport_id from airport_cl"+
				" where airport_full_name = '"+toPlace+"'))";
		Flight f = null;
		conn = ConnectUtils.getConnection();
		try {
			stmt = conn.createStatement();
			 rs= stmt.executeQuery(sql);
			
			while(rs.next()){
				f = new Flight();
				f.setFlight_id(rs.getInt("flight_id"));
				f.setFlight_num(rs.getString("flight_num"));
				f.setFlight_departu_date(rs.getDate("flight_departu_date"));
				f.setFlight_arrival_date(rs.getDate("flight_arrival_date"));
//				System.out.println(rs.getDate("flight_arrival_date").toString());
				f.setRoute_id(rs.getInt("route_id"));
				f.setPlane_id(rs.getInt("plane_id"));
				f.setF_seats_remain(rs.getInt("f_seats_remain"));
				f.setB_seats_remain(rs.getInt("b_seats_remain"));
				f.setE_seats_remian(rs.getInt("e_seats_remian"));
				f.setLowest_discount_price(rs.getInt("lowest_discount_price"));
				flight.add(f);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return flight;
	}

	@Override
	public List<Flight> getFlightMessageByid(String flightNum) {
		String sql = "select * from flight_cl where flight_num = '"+flightNum+"'";
		conn = ConnectUtils.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Flight f = new Flight();
				f.setFlight_id(rs.getInt("flight_id"));
				f.setFlight_num(rs.getString("flight_num"));
				f.setFlight_departu_date(rs.getDate("flight_departu_date"));
				f.setFlight_arrival_date(rs.getDate("flight_arrival_date"));
				f.setRoute_id(rs.getInt("route_id"));
				f.setPlane_id(rs.getInt("plane_id"));
				f.setF_seats_remain(rs.getInt("f_seats_remain"));
				f.setB_seats_remain(rs.getInt("b_seats_remain"));
				f.setE_seats_remian(rs.getInt("e_seats_remian"));
				f.setLowest_discount_price(rs.getInt("lowest_discount_price"));
				flight.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return flight;
	}
	
	public List<Integer> findPlaneSeats(Flight f){
		String sql =" select f_cabin_seats,c_cabin_seats,y_cabin_seats from plane_cl where plane_id = "+f.getPlane_id();
		List<Integer> list = new ArrayList<Integer>();
		conn = ConnectUtils.getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(rs.getInt("f_cabin_seats"));
				list.add(rs.getInt("c_cabin_seats"));
				list.add(rs.getInt("y_cabin_seats"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return list;
	}
	@Override
	public boolean updateFlight(Flight f) {
		List<Integer> list = findPlaneSeats(f);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sql1 = "update flight_cl set flight_departu_date =to_date('"+fmt.format(f.getFlight_departu_date())+
		"','yyyy-mm-dd'), flight_arrival_date = to_date('"+fmt.format(f.getFlight_arrival_date())+ "','yyyy-mm-dd'), route_id = "+ f.getRoute_id()+ ", " +
				" plane_id = "+f.getPlane_id()+",lowest_discount_price = "+ f.getLowest_discount_price()+", f_seats_remain = "+
				 list.get(0)+", b_seats_remain ="+list.get(1)+", e_seats_remian ="+list.get(2)
				 +" where flight_num ='"+f.getFlight_num().trim()+"'";
			//alter table mylog_cl modify column(what charvar(100); 
//		String sql1 = "update flight_cl set Lowest_discount_price = 900 where flight_num = '"+f.getFlight_num()+"'";
//		String[] str = sql1.split("where");
		String sql2 = "insert into mylog_cl values(log_cl.nextval, user, sysdate , 'update flight_cl:修改航班表"+f.getFlight_num()+"')";
		conn = ConnectUtils.getConnection();
		boolean b = false;
		System.out.println(sql1);
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
	public boolean deleteFlight(String str) {
		String sql1 =" delete from flight_cl where flight_num = '"+str+"'";
		String sql2 = "insert into mylog_cl values(log_cl.nextval, user, sysdate , 'delete flight_cl:删除航班表"+str+"')";
		conn = ConnectUtils.getConnection();
		boolean boo = false;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
//			  System.out.println("n1:"+n1);
			int n2 = stmt.executeUpdate(sql2);
//			System.out.println("n2:"+n2);
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
	public boolean addFlight(Flight f) {
		boolean boo = false;
		List<Integer> lm= findPlaneSeats(f);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String sql1 = "insert into flight_cl values(gg.nextval,'"+f.getFlight_num()+"',to_date('"+fmt.format(f.getFlight_departu_date())+"','yyyy-mm-dd')," +
				" to_date('"+fmt.format(f.getFlight_arrival_date())+"','yyyy-mm-dd'), "+f.getRoute_id()+", "+f.getPlane_id()+"," +
						lm.get(0)+", "+lm.get(1)+","+lm.get(2)+","+f.getLowest_discount_price()+")";
		String sql2 = "insert into mylog_cl values(log_cl.nextval, " +
			"user, sysdate , 'delete flight_cl:添加航班表"+f.getFlight_num()+"')";
		try {
			conn = ConnectUtils.getConnection();
//			 System.out.println(sql1);
//			  System.out.println(sql2);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int n1 = stmt.executeUpdate(sql1);
//			  System.out.println("n1:"+n1);
			 
			int n2 = stmt.executeUpdate(sql2);
//			System.out.println("n2:"+n2);
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
