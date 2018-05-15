package javatuning.ch2.proxy.dynamic;

import javatuning.ch2.proxy.IDBQuery;

public class DBQuery implements IDBQuery{
	public DBQuery(){
		//为了测试代理的调用性能，去掉这里的延时操作
	}
	@Override
	public String request() {
		return "request string";
	}
}
