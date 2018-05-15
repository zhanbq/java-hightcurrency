package com.zhanbq.performanceoptimazation.CH3.javatuning.ch3.teststr;

public class SameValueString {
	public static void main(String args[]){
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		System.out.println(str1==str2);//����true
		System.out.println(str1==str3);//����false
		System.out.println(str1==str3.intern());//����true
	}
}
