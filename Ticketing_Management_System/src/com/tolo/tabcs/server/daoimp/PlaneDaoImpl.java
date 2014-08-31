package com.tolo.tabcs.server.daoimp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import com.tolo.tabcs.server.dao.PlaneDao;
import com.tolo.tabcs.util.ConnectUtils;

public class PlaneDaoImpl implements PlaneDao{
	private Connection conn = null;
	private Statement stmt = null;
	public PlaneDaoImpl(){
//		System.out.println(searchPlaneModel(1001203159));
//		System.out.println(searchPlaneModelByNone());
//		System.out.println(searchPlaneId("boeing777"));
	}
	@Override
	public String searchPlaneModel(int planeid) {
		conn = ConnectUtils.getConnection();
		String pmodel = null;
		ResultSet rs  =null;
		String sql = " select plane_model from plane_cl where plane_id = "+planeid;
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			if(rs.next()){
				pmodel = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return pmodel;
	}

	@Override
	public String[] searchPlaneModelByNone() {
		conn = ConnectUtils.getConnection();
		String[] pmodel = new String[]{};;
		ResultSet rs  =null;
		String sql = "select plane_model from plane_cl";
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()){
				pmodel = Arrays.copyOf(pmodel, pmodel.length+1);
				pmodel[pmodel.length-1] = rs.getString("plane_model");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return pmodel;
	}
	
	public int searchPlaneId(String planeModel) {
		conn = ConnectUtils.getConnection();
		int planeId = 0;
		ResultSet rs  =null;
		String sql = " select plane_id from plane_cl where plane_model = '"+planeModel+"'";
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
		if(rs.next()){
				planeId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return planeId;
	}
	@Override
	public int findConfuel(String ftype) {
		conn = ConnectUtils.getConnection();
		int airport_fee = 0;
		ResultSet rs  =null;
		String sql = " select airport_fee from plane_cl where plane_model = '"+ftype+"'";
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
		if(rs.next()){
			airport_fee = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectUtils.close(rs);
			ConnectUtils.close(stmt);
			ConnectUtils.close(conn);
		}
		return airport_fee;
	}
	
//		public static void main(String[] args) {
//		PlaneDaoImpl d = new PlaneDaoImpl();
//	}
}
