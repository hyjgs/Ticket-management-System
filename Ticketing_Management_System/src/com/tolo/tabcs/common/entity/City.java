package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class City implements Serializable{
    private int id;//城市编号
    private String name;//城市名称
    private int province_id;//省份编号
    private String spell_name;//城市拼音
    
    public City(){
    }
   
	public City(int id, String name, int provinceId, String spellName) {
	super();
	this.id = id;
	this.name = name;
	province_id = provinceId;
	spell_name = spellName;
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
	
	public int getProvince_id() {
		return province_id;
	}
	
	public void setProvince_id(int provinceId) {
		province_id = provinceId;
	}
	
	public String getSpell_name() {
		return spell_name;
	}
	
	public void setSpell_name(String spellName) {
		spell_name = spellName;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	 if(obj instanceof City){
		 City c=(City)obj;
		 return c.name==this.name&&c.id==this.id;
	 }
		return false;
	}
	
}
