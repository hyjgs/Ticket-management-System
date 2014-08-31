package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Role implements Serializable{
	private int id;//角色编号
	private String name;//角色名称
	private int role_privilege;//角色权限
	public Role(){
		
	}
	public Role(int id, String name, int rolePrivilege) {
		super();
		this.id = id;
		this.name = name;
		role_privilege = rolePrivilege;
	}
	public Role(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole_privilege() {
		return role_privilege;
	}
	public void setRole_privilege(int rolePrivilege) {
		role_privilege = rolePrivilege;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==null){
			return false;
		}
		if(this==obj){
		return true;
		}
		if(obj instanceof Role){
			Role r = (Role)obj;
			return r.id==this.id;
		}
		return false;
	}
	
}
