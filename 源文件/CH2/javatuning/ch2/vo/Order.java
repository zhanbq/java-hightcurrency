package javatuning.ch2.vo;

public class Order implements java.io.Serializable{
	private int orderid;
	private String clientName;
	private int number;
	private String produnctName;

	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String name) {
		this.clientName = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getProdunctName() {
		return produnctName;
	}
	public void setProdunctName(String produnctName) {
		this.produnctName = produnctName;
	}
	
}
