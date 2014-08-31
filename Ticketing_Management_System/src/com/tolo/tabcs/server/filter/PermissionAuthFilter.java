package com.tolo.tabcs.server.filter;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class PermissionAuthFilter implements Filter{

	public Response doFilter(Request req, Response res) {
		
		String loginName=(String)req.getData("LoginName");
		//用户屏蔽，禁止登录等
		if(loginName.equals("chentx")){//禁止chentx该用户登录，屏蔽用户
			res.addData("AuthState", "WRONGWORD_LOGIN_ERROR");
			return res;
		}else{
			res.addData("AuthState", "OK");
			return res;
		}
	}

}
