package javatuning.ch2.pool;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool.PoolableObjectFactory;

public class PoolableObjectFactoryDemo implements PoolableObjectFactory {
	private static  AtomicInteger counter = new AtomicInteger(0);

	public Object makeObject() throws Exception {
		Object obj = String.valueOf(counter.getAndIncrement());
		System.out.println("Create Object " + obj);
		return obj;
	}

	public void activateObject(Object obj) throws Exception {
		System.out.println("Before borrow " + obj);
	}

	public void passivateObject(Object obj) throws Exception {
		System.out.println("return "+obj);
	}

	public boolean validateObject(Object obj) {
		return true;
	}

	public void destroyObject(Object obj) throws Exception {
		System.out.println("Destroying Object " + obj);
	}
}
