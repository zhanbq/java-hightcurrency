package javatuning.ch5.memory;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/**
 * -XX:PermSize=4M -XX:MaxPermSize=4M -XX:+PrintGCDetails
 * @author Administrator
 *
 */
public class TestPermMax {
	public static void main(String args[]) throws CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException{
		int i=0;
		try{
			for (i = 1; i <=Integer.MAX_VALUE; i++) {
				CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
				c.setSuperclass(ClassPool.getDefault().get("javatuning.ch5.memory.JavaBeanObject"));
				Class clz = c.toClass();
				JavaBeanObject v=(JavaBeanObject)clz.newInstance();
			}
		}catch(Throwable e){
			System.out.println("Create New Classes count is "+i);
			e.printStackTrace();
		}
	}
}
