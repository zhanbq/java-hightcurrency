package com.zhanbq.performanceoptimazation.CH2.javatuning.ch2.decorator;

public abstract class PacketDecorator implements IPacketCreator{
	IPacketCreator componet;
	public PacketDecorator(IPacketCreator c){
		componet=c;
	}
}
