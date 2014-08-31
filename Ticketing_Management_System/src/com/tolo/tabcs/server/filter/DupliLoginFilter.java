package com.tolo.tabcs.server.filter;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.service.ServerMainClass;
/**
 * 验证是否重复登录
 * @author TangLiang
 */
public class DupliLoginFilter implements Filter{

	public Response doFilter(Request req, Response res) {
		
		String loginName=(String)req.getData("LoginName");
		if(ServerMainClass.onlineUsers.containsKey(loginName)){
			
			if(ServerMainClass.onlineUsers.get(loginName)!=null){
				res.addData("AuthState", "DUP_LOGIN_ERROR");
				return res;
			}else{
				res.addData("AuthState","OK");
				return res;
			}
			
		}else{
			res.addData("AuthState","OK");
			return res;
		}
	}
	

}
