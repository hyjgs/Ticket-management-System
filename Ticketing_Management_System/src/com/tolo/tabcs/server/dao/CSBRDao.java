package com.tolo.tabcs.server.dao;

import java.util.List;

import com.tolo.tabcs.common.entity.Branch;

public interface CSBRDao {
//	List getCSBR_branch(String branch);
//	List getCSBR();
//	List getCSBR_city(String city);
//	List getCSBR_province(String province);
	List getCSBR_branch(String branchName);
	List getCSBR_city(String cityName);
	List getCSBR_province(String provinceName);
	List getCSBR();
	
}
