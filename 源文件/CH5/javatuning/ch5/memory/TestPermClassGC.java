package javatuning.ch5.memory;

import java.lang.reflect.Method;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.junit.Test;

/**
 * -XX:PermSize=2M -XX:MaxPermSize=4M -XX:+PrintGCDetails
 * 
 * @author HZ20163
 * 
 */
public class TestPermClassGC {
	static MyClassLoader cl = new MyClassLoader();

	//@Test
	public void testOneClassLoad()throws CannotCompileException, InstantiationException,
		IllegalAccessException, NotFoundException{
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
			c.setSuperclass(ClassPool.getDefault().get("javatuning.ch5.memory.JavaBeanObject"));
			Class clz = c.toClass();
			JavaBeanObject v=(JavaBeanObject)clz.newInstance();
		}
	}
	
	@Test
	public void testNewClassLoad() throws CannotCompileException, InstantiationException,
			IllegalAccessException, NotFoundException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
			c.setSuperclass(ClassPool.getDefault().get("javatuning.ch5.memory.JavaBeanObject"));
			Class clz = c.toClass(cl, null);
			JavaBeanObject v=(JavaBeanObject)clz.newInstance();
			if(i%10==0)
				cl = new MyClassLoader();
		}
	}
}