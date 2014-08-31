package com.tolo.tabcs.common.entity;

import java.io.Serializable;

public class AppliedRecord implements Serializable {
	private int seller_id;//买票人编号
	private String applied_count;//申请帐户
	private String applied_sum;//申请编号
	private String unapplied_count;//未申请帐户
	private String unapplied_sum;//未申请帐户编号

		public AppliedRecord(){
			
		}
		
		public int getSeller_id() {
			return seller_id;
		}
		
		public void setSeller_id(int sellerId) {
			seller_id = sellerId;
		}
		
		public String getApplied_count() {
			return applied_count;
		}
		
		public void setApplied_count(String appliedCount) {
			applied_count = appliedCount;
		}
		
		public String getApplied_sum() {
			return applied_sum;
		}
		
		public void setApplied_sum(String appliedSum) {
			applied_sum = appliedSum;
		}
		
		public String getUnapplied_count() {
			return unapplied_count;
		}
		
		public void setUnapplied_count(String unappliedCount) {
			unapplied_count = unappliedCount;
		}
		
		public String getUnapplied_sum() {
			return unapplied_sum;
		}
		
		public void setUnapplied_sum(String unappliedSum) {
			unapplied_sum = unappliedSum;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + seller_id;
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
			AppliedRecord other = (AppliedRecord) obj;
			if (seller_id != other.seller_id)
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "AppliedRecord [applied_count=" + applied_count + ", applied_sum="
					+ applied_sum + ", seller_id=" + seller_id + ", unapplied_count="
					+ unapplied_count + ", unapplied_sum=" + unapplied_sum + "]";
		}

	
}
