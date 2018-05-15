package javatuning.ch4.gs.future;

import javatuning.ch4.future.pattern.Data;

public class Request {
    private String name;
    private Data response;
    
    public synchronized Data getResponse() {
		return response;
	}
	public synchronized void setResponse(Data response) {
		this.response = response;
	}
	
	public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "[ Request " + name + " ]";
    }
}
