package com.tolo.tabcs.server.action;

import java.util.List;

import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.dao.CSBRDao;
import com.tolo.tabcs.server.daoimp.CSBRDaoImpl;
import com.tolo.tabcs.server.service.ServerAction;

public class serverCSBRAction extends ServerAction{

	@Override
	public void doAction(Request req, Response res) {
//		System.out.println("进到Action没");
//		String branch =(String)req.getData("branchName");
//		String city =(String)req.getData("cityName");
//		String province =(String)req.getData("provinceName");
//		System.out.println("branch"+branch);
//		System.out.println("city"+city);
//		System.out.println("province"+province);
////		CSBRDao csbrDao = (CSBRDao)DAOFactory.getInstance(CSBRDao.class);
//		CSBRDao csbrDao = new CSBRDaoImpl();
//		List list1 = csbrDao.getCSBR_branch(branch);
//		List list2 = csbrDao.getCSBR_city(city);
//		List list3 = csbrDao.getCSBR_province(province);
//		List list4 = csbrDao.getCSBR();
//		res.addData("CSBR_branch",list1);
//		res.addData("CSBR_city",list2);
//		res.addData("CSBR_province",list3);
//		res.addData("CSBR",list4);
		String branchName =(String)req.getData("branchName");
		String cityName = (String)req.getData("cityName");
		String provinceName = (String)req.getData("provinceName");
//		System.out.println("branch"+branchName);
//		System.out.println("city"+cityName);
//		System.out.println("province"+provinceName);
//		CSBRDao csbrDao = (CSBRDao)DAOFactory.getInstance(CSBRDao.class);
		CSBRDao csbrDao = new CSBRDaoImpl();
		
		List list1 = (List) csbrDao.getCSBR_branch(branchName);
		List list2 = (List) csbrDao.getCSBR_city(cityName);
		List list3 = (List) csbrDao.getCSBR_province(provinceName);
		List list4 = (List) csbrDao.getCSBR();
		
		res.addData("CSBR_branch", list1);
		res.addData("CSBR_city",list2);
		res.addData("CSBR_province", list3);
		res.addData("CSBR",list4);
	}

}
