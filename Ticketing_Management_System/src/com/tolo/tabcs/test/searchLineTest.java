package com.tolo.tabcs.test;

import com.tolo.tabcs.common.entity.Route;
import com.tolo.tabcs.server.dao.SearchLine;
import com.tolo.tabcs.server.daoimp.SearchLineImp;

public class searchLineTest {
    public static void main(String[] args) {
		SearchLine s=new SearchLineImp();
		Route r = new Route("北京","上海");
		int[] a=  s.getRouteId(r);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
