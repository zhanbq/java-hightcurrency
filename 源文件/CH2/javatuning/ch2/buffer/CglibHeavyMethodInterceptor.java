package javatuning.ch2.buffer;

import java.io.Serializable;
import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibHeavyMethodInterceptor implements MethodInterceptor {
	HeavyMethodDemo real=new HeavyMethodDemo();
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		String v=(String)EHCacheUtil.get("cache1", (Serializable)arg2[0]);
		if(v==null){
		   v=real.heavyMethod((Integer)arg2[0]);
		   EHCacheUtil.put("cache1", (Integer)arg2[0], v);
		}
		return v;
	}
	
	public static HeavyMethodDemo newCacheHeavyMethod(){
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(HeavyMethodDemo.class);
        enhancer.setCallback(new CglibHeavyMethodInterceptor());  
        HeavyMethodDemo cglibProxy = (HeavyMethodDemo) enhancer.create();  
        return cglibProxy;  
	}
	public static HeavyMethodDemo newHeavyMethod(){
		return new HeavyMethodDemo();
	}
	public static void main(String args[]){
		HeavyMethodDemo m=newCacheHeavyMethod();
		long begin = System.currentTimeMillis();
		for(int i=0;i<100000;i++)
			m.heavyMethod(2147483646);
		System.out.println("cache method spend:"+(System.currentTimeMillis()-begin));
		
		m=newHeavyMethod();
		begin = System.currentTimeMillis();
		for(int i=0;i<100000;i++)
			m.heavyMethod(2147483646);
		System.out.println("no cache method spend:"+(System.currentTimeMillis()-begin));
	}
}
