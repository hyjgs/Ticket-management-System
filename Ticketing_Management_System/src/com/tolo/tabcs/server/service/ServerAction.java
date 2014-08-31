package com.tolo.tabcs.server.service;

import java.util.ArrayList;
import java.util.List;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.server.filter.Filter;
/**
 * 行为处理以及过滤的中转类
 * 可以根据请求类型的不同交给不同的类去处理
 * 可以根据过滤的要求不同交给不同的过滤器去过滤
 * @author TangLiang
 */
public abstract class ServerAction {
	private List<Filter> chain;//储存过滤器的集合
	
	public ServerAction(){
		chain=new ArrayList<Filter>();
	}
	
	protected void doActionOne(Request req,Response res){
		
		if(!doFilter(req,res)){//先过滤在执行程序
			return;
		}
		
		doAction(req,res);//把业务交给不同的类去处理
	}
	
	private boolean doFilter(Request req,Response res){//过滤方法
		for(int i=0;i<chain.size();i++){
			Filter filter=chain.get(i);
			Response response=filter.doFilter(req, res);
			if(!response.getData("ok").equals("OK")){
				return false;
			}
		}
		return true;
	}
	
	public void addFilter(Filter filter){//子类在new的过程中可以加入过滤器
		chain.add(filter);
	}
	
	public abstract void doAction(Request req,Response res);

}
