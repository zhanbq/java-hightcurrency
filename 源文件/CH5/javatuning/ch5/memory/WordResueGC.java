package javatuning.ch5.memory;

/**
 * -verbose:gc
 * @author Administrator
 *
 */
public class WordResueGC {
	
	public static  void test1(){		//gc无法回收，因为b还在局部变量表中
		{
		byte[] b=new byte[6*1204*1024];
		}
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test2(){		//gc可以回收，因为赋值为null将销毁局部变量表中的数据
		{
		byte[] b=new byte[6*1204*1024];
		b=null;
		}
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test3(){		//gc可以回收，因为变量a复用了b的字，GC根无法找到b
		{
		byte[] b=new byte[6*1204*1024];
		}
		int a=0;
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test4(){		//gc无法回收，因为变量a复用了c的字，b仍然存在
		{
		int c=0;
		byte[] b=new byte[6*1204*1024];
		}
		int a=0;
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test5(){		//gc可以回收，因为变量d复用了b的字
		{
		int c=0;
		byte[] b=new byte[6*1204*1024];
		}
		int a=0;
		int d=0;
		System.gc();
		System.out.println("first explict gc over");
	}

	public static void main(String args[]){
		test1();
		System.gc();					//总是可以回收b，因为上层函数的栈栈已经销毁
		System.out.println("second explict gc over");
	}
}
