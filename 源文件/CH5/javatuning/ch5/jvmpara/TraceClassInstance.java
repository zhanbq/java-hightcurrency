package javatuning.ch5.jvmpara;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javatuning.ch5.memory.JavaBeanObject;
import javatuning.ch5.memory.MyClassLoader;
import javatuning.ch5.memory.MyMethodInterceptor;
import net.sf.cglib.proxy.MethodInterceptor;

/**
-XX:+TraceClassUnloading 
-XX:+TraceClassLoading
-XX:+TraceClassResolution
-verbose:class
-Xnoclassgc
-verbose:class -XX:MaxPermSize=10M -Xnoclassgc -Xincgc
 * 
 */
public class TraceClassInstance {
	static MyClassLoader cl = new MyClassLoader();
	static MethodInterceptor mi=new MyMethodInterceptor();

	public static void main(String[] args) throws CannotCompileException, InstantiationException,
			IllegalAccessException, NotFoundException {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			JavaBeanObject v=createInstance2(i);
			cl = new MyClassLoader();
		}
	}

	private static JavaBeanObject createInstance2(int i) throws CannotCompileException,
			InstantiationException, IllegalAccessException, NotFoundException {
		CtClass c = ClassPool.getDefault().makeClass("Geym" + i);
		c.setSuperclass(ClassPool.getDefault().get("javatuning.ch5.memory.JavaBeanObject"));
		Class clz = c.toClass(cl, null);
		return (JavaBeanObject)clz.newInstance();
	}
}