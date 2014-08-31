package com.tolo.tabcs.util;

/**
 * 提供判断是否是合法的身份证验证
 *
 */
public class VertifyUtil {
	public static boolean verify(String id){
		char[] ch = id.toCharArray();
		if(ch.length!=18) {
			return false;
		}
		int sum = 0;
		int[] w = { 7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		for (int i = 0; i < 17; i++) {
			sum+=(ch[i] - '0')*w[i];
		}
		char[] code ="10X98765432".toCharArray();
		char c = code[sum%11];
		return ch[17]==c;
	}
	
		
	public static void main(String[] args){
		boolean str = VertifyUtil.verify("330304199104092114");
		System.out.println(str);
	}

}
