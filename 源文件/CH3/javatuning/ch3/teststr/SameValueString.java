package javatuning.ch3.teststr;

public class SameValueString {
	public static void main(String args[]){
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		System.out.println(str1==str2);//·µ»Øtrue
		System.out.println(str1==str3);//·µ»Øfalse
		System.out.println(str1==str3.intern());//·µ»Øtrue
	}
}
