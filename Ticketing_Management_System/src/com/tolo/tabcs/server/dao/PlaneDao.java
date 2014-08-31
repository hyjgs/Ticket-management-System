package com.tolo.tabcs.server.dao;

public interface PlaneDao {

	public String searchPlaneModel(int planeid);

	public String[] searchPlaneModelByNone();
	
	public int searchPlaneId(String planeModel);
	public int findConfuel(String ftype);
}
