package javatuning.ch2.proxy.dynamic;

import java.lang.reflect.Method;

import javatuning.ch2.proxy.IDBQuery;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDbQueryInterceptor implements MethodInterceptor {
	IDBQuery real=null;
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		if(real==null)
			real=new DBQuery();
		return real.request();	
	}
}
