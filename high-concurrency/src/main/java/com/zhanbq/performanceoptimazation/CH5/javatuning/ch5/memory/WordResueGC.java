package com.zhanbq.performanceoptimazation.CH5.javatuning.ch5.memory;

/**
 * -verbose:gc
 * @author Administrator
 *
 */
public class WordResueGC {
	
	public static  void test1(){		//gc�޷����գ���Ϊb���ھֲ���������
		{
		byte[] b=new byte[6*1204*1024];
		}
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test2(){		//gc���Ի��գ���Ϊ��ֵΪnull�����پֲ��������е�����
		{
		byte[] b=new byte[6*1204*1024];
		b=null;
		}
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test3(){		//gc���Ի��գ���Ϊ����a������b���֣�GC���޷��ҵ�b
		{
		byte[] b=new byte[6*1204*1024];
		}
		int a=0;
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test4(){		//gc�޷����գ���Ϊ����a������c���֣�b��Ȼ����
		{
		int c=0;
		byte[] b=new byte[6*1204*1024];
		}
		int a=0;
		System.gc();
		System.out.println("first explict gc over");
	}
	public static  void test5(){		//gc���Ի��գ���Ϊ����d������b����
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
		System.gc();					//���ǿ��Ի���b����Ϊ�ϲ㺯����ջջ�Ѿ�����
		System.out.println("second explict gc over");
	}
}
