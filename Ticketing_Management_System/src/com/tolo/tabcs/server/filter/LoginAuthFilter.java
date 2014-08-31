package com.tolo.tabcs.server.filter;

import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
/**
*
 * 验证用户是否是合法登录用户的验证器。
* @author hyj
*
*/



public class LoginAuthFilter implements Filter{

	public Response doFilter(Request req, Response res) {
		
		User user=(User)req.getData("user");
		//脏话,不文明的用语,禁止使用的话,长度，规则等过滤
//		System.out.println(user.getName());
		if(user.getName().equals("SB")){
			res.addData("result", "sorry");
			return res;
		}else{
			res.addData("result", "ok");
			return res;
		}
	}
	

}
