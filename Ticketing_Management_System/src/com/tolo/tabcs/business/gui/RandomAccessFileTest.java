package com.tolo.tabcs.business.gui;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class RandomAccessFileTest {
//	public static void main1(String str1,List<SalesBusinessLog> list){
//		RandomAccessFile raf=null;
//		//FileOutputStream fos=null;
//		long num=0;
//		try {
//			raf=new RandomAccessFile(str1,"rw");
//			String str="";
//			for(int i=0;i<list.size();i++){
//				str=str+list.get(i).toString()+"\n";
//			}
//			System.out.println(str);
//			raf.write(str.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			if(raf!=null){
//				try {
//					raf.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	public static void main2(String str1,List<String> list){
		RandomAccessFile raf=null;
		//FileOutputStream fos=null;
		@SuppressWarnings("unused")
		long num=0;
		try {
			raf=new RandomAccessFile(str1,"rw");
			String str="";
			for(int i=0;i<list.size();i++){
				str=str+list.get(i)+"\n";
			}
			System.out.println(str);
			raf.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(raf!=null){
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}