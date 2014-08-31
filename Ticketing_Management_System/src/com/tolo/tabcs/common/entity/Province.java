package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class Province implements Serializable{
   private int id;//省份编号
   private String name;//省份名称
   private String simple_name;//省份简称
   private String spell_name;//省份拼音
   
   public Province() {
	super();
   }
   
   public Province(int id,String name,String simple_name,String spell_name){
	   this.id = id;
	   this.name = name;
	   this.simple_name = simple_name;
	   this.spell_name = spell_name;
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
	
	public String getSimple_name() {
		return simple_name;
	}
	
	public void setSimple_name(String simpleName) {
		simple_name = simpleName;
	}
	
	public String getSpell_name() {
		return spell_name;
	}
	
	public void setSpell_name(String spellName) {
		spell_name = spellName;
	}

}
