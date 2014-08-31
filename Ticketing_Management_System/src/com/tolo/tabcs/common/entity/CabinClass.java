package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class CabinClass implements Serializable {
		private int cabin_class_id;//舱位等级编号
		private String cabin_class_name;//舱位等级名称
		private	String cabin_class_char;//舱位等级字符
		private	double refund_charge;//退票手续费
		private	String	limit_condition;//限制条件
		private	double cabin_discount;//舱位折扣
		private	String plane_cabin_type;//飞机舱位
		private	double mileage_factor;//里程系数
		private int turn_charge;//签转手续费
		private int redate_charge;//改期手续费
		
		public CabinClass(){
		}
		
		public int getCabin_class_id() {
			return cabin_class_id;
		}
		
		public void setCabin_class_id(int cabinClassId) {
			cabin_class_id = cabinClassId;
		}
		
		public String getCabin_class_name() {
			return cabin_class_name;
		}
		
		public void setCabin_class_name(String cabinClassName) {
			cabin_class_name = cabinClassName;
		}
		
		public String getCabin_class_char() {
			return cabin_class_char;
		}
		
		public void setCabin_class_char(String cabinClassChar) {
			cabin_class_char = cabinClassChar;
		}
		
		public double getRefund_charge() {
			return refund_charge;
		}
		
		public void setRefund_charge(double refundCharge) {
			refund_charge = refundCharge;
		}
		
		public String getLimit_condition() {
			return limit_condition;
		}
		
		public void setLimit_condition(String limitCondition) {
			limit_condition = limitCondition;
		}
		
		public double getCabin_discount() {
			return cabin_discount;
		}
		
		public void setCabin_discount(double cabinDiscount) {
			cabin_discount = cabinDiscount;
		}
		
		public String getPlane_cabin_type() {
			return plane_cabin_type;
		}
		
		public void setPlane_cabin_type(String planeCabinType) {
			plane_cabin_type = planeCabinType;
		}
		
		public double getMileage_factor() {
			return mileage_factor;
		}
		
		public void setMileage_factor(double mileageFactor) {
			mileage_factor = mileageFactor;
		}
		
		public int getTurn_charge() {
			return turn_charge;
		}
		
		public void setTurn_charge(int turnCharge) {
			turn_charge = turnCharge;
		}
		
		public int getRedate_charge() {
			return redate_charge;
		}
		
		public void setRedate_charge(int redateCharge) {
			redate_charge = redateCharge;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cabin_class_id;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CabinClass other = (CabinClass) obj;
			if (cabin_class_id != other.cabin_class_id)
				return false;
			return true;
		}

}
