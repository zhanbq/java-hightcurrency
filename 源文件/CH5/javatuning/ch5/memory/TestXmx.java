package javatuning.ch5.memory;

import java.util.Vector;

import org.junit.Test;

/**
 * -Xmx11M
 * @author Administrator
 *
 */
public class TestXmx {
	public static void main(String args[]){
		Vector v=new Vector();
		for(int i=1;i<=10;i++){
			byte[] b=new byte[1024*1024];
			v.add(b);
			System.out.println(i+"M is allocated");
		}
		System.out.println("Max memory:"+Runtime.getRuntime().maxMemory()/1024/1024+"M");
	}
}
